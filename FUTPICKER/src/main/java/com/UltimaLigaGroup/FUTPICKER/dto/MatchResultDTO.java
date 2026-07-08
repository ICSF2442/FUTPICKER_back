package com.UltimaLigaGroup.FUTPICKER.dto;

import java.time.LocalDateTime;
import java.util.List;

public class MatchResultDTO {
    private Long id;
    private LocalDateTime playedAt;
    private Integer teamAScore;
    private Integer teamBScore;
    private List<MatchPlayerDTO> players;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getPlayedAt() { return playedAt; }
    public void setPlayedAt(LocalDateTime playedAt) { this.playedAt = playedAt; }
    public Integer getTeamAScore() { return teamAScore; }
    public void setTeamAScore(Integer teamAScore) { this.teamAScore = teamAScore; }
    public Integer getTeamBScore() { return teamBScore; }
    public void setTeamBScore(Integer teamBScore) { this.teamBScore = teamBScore; }
    public List<MatchPlayerDTO> getPlayers() { return players; }
    public void setPlayers(List<MatchPlayerDTO> players) { this.players = players; }
}