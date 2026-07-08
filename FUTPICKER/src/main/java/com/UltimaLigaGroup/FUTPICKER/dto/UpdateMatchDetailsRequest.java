package com.UltimaLigaGroup.FUTPICKER.dto;

import java.util.List;

public class UpdateMatchDetailsRequest {
    private Integer teamAScore;
    private Integer teamBScore;
    private Long mvpPlayerId;
    private List<PlayerMatchStatsDTO> playerStats;

    public Integer getTeamAScore() { return teamAScore; }
    public void setTeamAScore(Integer teamAScore) { this.teamAScore = teamAScore; }
    public Integer getTeamBScore() { return teamBScore; }
    public void setTeamBScore(Integer teamBScore) { this.teamBScore = teamBScore; }
    public Long getMvpPlayerId() { return mvpPlayerId; }
    public void setMvpPlayerId(Long mvpPlayerId) { this.mvpPlayerId = mvpPlayerId; }
    public List<PlayerMatchStatsDTO> getPlayerStats() { return playerStats; }
    public void setPlayerStats(List<PlayerMatchStatsDTO> playerStats) { this.playerStats = playerStats; }
}