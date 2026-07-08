package com.UltimaLigaGroup.FUTPICKER.service;

import com.UltimaLigaGroup.FUTPICKER.dto.PlayerDTO;
import com.UltimaLigaGroup.FUTPICKER.dto.TeamGenerationRequest;
import com.UltimaLigaGroup.FUTPICKER.dto.TeamGenerationResponse;
import com.UltimaLigaGroup.FUTPICKER.entity.Player;
import com.UltimaLigaGroup.FUTPICKER.exception.ResourceNotFoundException;
import com.UltimaLigaGroup.FUTPICKER.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamBalancerService {

    private final PlayerRepository playerRepository;

    public TeamBalancerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public TeamGenerationResponse generateTeams(TeamGenerationRequest request) {
        List<Long> playerIds = request.getPlayerIds();
        if (playerIds == null || playerIds.isEmpty()) {
            throw new IllegalArgumentException("No players selected.");
        }
        if (playerIds.size() % 2 != 0) {
            throw new IllegalArgumentException("Number of selected players must be even.");
        }

        Map<Long, String> locked = request.getLockedAssignments() != null
                ? request.getLockedAssignments()
                : Collections.emptyMap();

        List<Player> players = playerRepository.findAllById(playerIds);
        if (players.size() != playerIds.size()) {
            throw new ResourceNotFoundException("One or more selected players were not found.");
        }

        List<Player> teamA = new ArrayList<>();
        List<Player> teamB = new ArrayList<>();
        double teamAScore = 0;
        double teamBScore = 0;
        int teamAGkCount = 0;
        int teamBGkCount = 0;

        List<Player> unlocked = new ArrayList<>();

        for (Player player : players) {
            String lockedTeam = locked.get(player.getId());
            if ("A".equalsIgnoreCase(lockedTeam)) {
                teamA.add(player);
                teamAScore += score(player);
                if (Boolean.TRUE.equals(player.getIsGoalkeeper())) teamAGkCount++;
            } else if ("B".equalsIgnoreCase(lockedTeam)) {
                teamB.add(player);
                teamBScore += score(player);
                if (Boolean.TRUE.equals(player.getIsGoalkeeper())) teamBGkCount++;
            } else {
                unlocked.add(player);
            }
        }

        unlocked.sort((p1, p2) -> Double.compare(score(p2), score(p1)));

        for (Player player : unlocked) {
            boolean isGk = Boolean.TRUE.equals(player.getIsGoalkeeper());
            boolean assignToA;

            if (isGk && teamAGkCount != teamBGkCount) {
                assignToA = teamAGkCount < teamBGkCount;
            } else {
                assignToA = teamAScore <= teamBScore;
            }

            if (assignToA) {
                teamA.add(player);
                teamAScore += score(player);
                if (isGk) teamAGkCount++;
            } else {
                teamB.add(player);
                teamBScore += score(player);
                if (isGk) teamBGkCount++;
            }
        }

        return new TeamGenerationResponse(toDTOs(teamA), toDTOs(teamB), round1(teamAScore), round1(teamBScore));
    }

    private double score(Player p) {
        return (p.getRit() + p.getTec() + p.getDef() + p.getRem()) / 4.0;
    }

    private double round1(double value) {
        return Math.round(value * 10) / 10.0;
    }

    private List<PlayerDTO> toDTOs(List<Player> players) {
        List<PlayerDTO> dtos = new ArrayList<>();
        for (Player p : players) {
            PlayerDTO dto = new PlayerDTO();
            dto.setId(p.getId());
            dto.setName(p.getName());
            dto.setRit(p.getRit());
            dto.setTec(p.getTec());
            dto.setDef(p.getDef());
            dto.setRem(p.getRem());
            dto.setOvr(p.getOvr());
            dto.setArchetype(p.getArchetype());
            dto.setIsGoalkeeper(p.getIsGoalkeeper());
            dtos.add(dto);
        }
        return dtos;
    }
}