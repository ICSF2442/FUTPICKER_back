package com.UltimaLigaGroup.FUTPICKER.dto;

public class PlayerMatchStatsDTO {
    private Long playerId;
    private Integer goals;
    private Integer assists;

    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }
    public Integer getGoals() { return goals; }
    public void setGoals(Integer goals) { this.goals = goals; }
    public Integer getAssists() { return assists; }
    public void setAssists(Integer assists) { this.assists = assists; }
}