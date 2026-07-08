package com.UltimaLigaGroup.FUTPICKER.service;

import com.UltimaLigaGroup.FUTPICKER.dto.*;
import com.UltimaLigaGroup.FUTPICKER.entity.Match;
import com.UltimaLigaGroup.FUTPICKER.entity.MatchPlayer;
import com.UltimaLigaGroup.FUTPICKER.entity.Player;
import com.UltimaLigaGroup.FUTPICKER.exception.ResourceNotFoundException;
import com.UltimaLigaGroup.FUTPICKER.repository.MatchPlayerRepository;
import com.UltimaLigaGroup.FUTPICKER.repository.MatchRepository;
import com.UltimaLigaGroup.FUTPICKER.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;
    private final MatchPlayerRepository matchPlayerRepository;

    public MatchService(MatchRepository matchRepository, PlayerRepository playerRepository,
                        MatchPlayerRepository matchPlayerRepository) {
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
        this.matchPlayerRepository = matchPlayerRepository;
    }

    public MatchResultDTO confirmMatch(ConfirmMatchRequest request) {
        if (request.getPlayers() == null || request.getPlayers().isEmpty()) {
            throw new IllegalArgumentException("No players provided for match.");
        }

        Match match = new Match();
        match.setName(request.getName());
        match.setLocation(request.getLocation());
        match.setTeamAColor(request.getTeamAColor());
        match.setTeamBColor(request.getTeamBColor());
        match.setTeamAScore(request.getTeamAScore());
        match.setTeamBScore(request.getTeamBScore());

        if (request.getMatchDate() != null && !request.getMatchDate().isBlank()) {
            match.setMatchDate(LocalDate.parse(request.getMatchDate()));
        }

        match = matchRepository.save(match);

        List<MatchPlayer> matchPlayers = new ArrayList<>();
        for (PlayerTeamAssignment assignment : request.getPlayers()) {
            Player player = playerRepository.findById(assignment.getPlayerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Player not found: " + assignment.getPlayerId()));

            MatchPlayer mp = new MatchPlayer();
            mp.setMatch(match);
            mp.setPlayer(player);
            mp.setTeam(MatchPlayer.Team.valueOf(assignment.getTeam().toUpperCase()));
            matchPlayers.add(mp);
        }
        matchPlayerRepository.saveAll(matchPlayers);

        return toDTO(match);
    }

    public List<MatchResultDTO> getAll() {
        return matchRepository.findAllByOrderByPlayedAtDesc().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<MatchResultDTO> getOngoing() {
        return matchRepository.findByTeamAScoreIsNullOrTeamBScoreIsNullOrderByMatchDateDesc().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<MatchResultDTO> getHistory() {
        return matchRepository.findByTeamAScoreIsNotNullAndTeamBScoreIsNotNullOrderByMatchDateDesc().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public MatchResultDTO getById(Long id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found: " + id));
        return toDTO(match);
    }

    public MatchResultDTO updateScore(Long id, UpdateScoreRequest request) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found: " + id));
        match.setTeamAScore(request.getTeamAScore());
        match.setTeamBScore(request.getTeamBScore());
        match = matchRepository.save(match);
        return toDTO(match);
    }

    public MatchResultDTO updateMatchDetails(Long id, UpdateMatchDetailsRequest request) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found: " + id));

        match.setTeamAScore(request.getTeamAScore());
        match.setTeamBScore(request.getTeamBScore());

        if (request.getMvpPlayerId() != null) {
            Player mvp = playerRepository.findById(request.getMvpPlayerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Player not found: " + request.getMvpPlayerId()));
            match.setMvp(mvp);
        } else {
            match.setMvp(null);
        }

        match = matchRepository.save(match);

        if (request.getPlayerStats() != null) {
            List<MatchPlayer> matchPlayers = matchPlayerRepository.findByMatchId(id);
            Map<Long, MatchPlayer> byPlayerId = matchPlayers.stream()
                    .collect(Collectors.toMap(mp -> mp.getPlayer().getId(), mp -> mp));

            for (PlayerMatchStatsDTO stat : request.getPlayerStats()) {
                MatchPlayer mp = byPlayerId.get(stat.getPlayerId());
                if (mp != null) {
                    mp.setGoals(stat.getGoals() != null ? stat.getGoals() : 0);
                    mp.setAssists(stat.getAssists() != null ? stat.getAssists() : 0);
                }
            }
            matchPlayerRepository.saveAll(matchPlayers);
        }

        return toDTO(match);
    }

    public PlayerRecordDTO getPlayerRecord(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found: " + playerId));

        List<MatchPlayer> appearances = matchPlayerRepository.findByPlayerId(playerId);

        int wins = 0, losses = 0, draws = 0;
        for (MatchPlayer mp : appearances) {
            Match match = mp.getMatch();
            Integer teamAScore = match.getTeamAScore();
            Integer teamBScore = match.getTeamBScore();
            if (teamAScore == null || teamBScore == null) continue;

            boolean onTeamA = mp.getTeam() == MatchPlayer.Team.A;
            int diff = onTeamA ? teamAScore - teamBScore : teamBScore - teamAScore;

            if (diff > 0) wins++;
            else if (diff < 0) losses++;
            else draws++;
        }

        return new PlayerRecordDTO(playerId, player.getName(), wins, losses, draws);
    }

    private MatchResultDTO toDTO(Match match) {
        MatchResultDTO dto = new MatchResultDTO();
        dto.setId(match.getId());
        dto.setName(match.getName());
        dto.setLocation(match.getLocation());
        dto.setMatchDate(match.getMatchDate());
        dto.setTeamAColor(match.getTeamAColor());
        dto.setTeamBColor(match.getTeamBColor());
        dto.setPlayedAt(match.getPlayedAt());
        dto.setTeamAScore(match.getTeamAScore());
        dto.setTeamBScore(match.getTeamBScore());

        if (match.getMvp() != null) {
            dto.setMvpPlayerId(match.getMvp().getId());
            dto.setMvpPlayerName(match.getMvp().getName());
        }

        List<MatchPlayer> matchPlayers = matchPlayerRepository.findByMatchId(match.getId());
        List<MatchPlayerDTO> playerDTOs = matchPlayers.stream()
                .map(mp -> new MatchPlayerDTO(mp.getPlayer().getId(), mp.getPlayer().getName(), mp.getTeam().name(), mp.getGoals(), mp.getAssists()))
                .collect(Collectors.toList());
        dto.setPlayers(playerDTOs);

        return dto;
    }
}