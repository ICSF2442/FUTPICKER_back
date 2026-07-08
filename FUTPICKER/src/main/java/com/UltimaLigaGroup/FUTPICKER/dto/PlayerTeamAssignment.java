package com.UltimaLigaGroup.FUTPICKER.dto;

public class PlayerTeamAssignment {
    private Long playerId;
    private String team; // "A" or "B"

    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }
    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }
}