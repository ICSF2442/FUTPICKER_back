package com.UltimaLigaGroup.FUTPICKER.dto;

import java.util.List;

public class ConfirmMatchRequest {
    private List<PlayerTeamAssignment> players;
    private Integer teamAScore; // optional, null if not played yet
    private Integer teamBScore;

    public List<PlayerTeamAssignment> getPlayers() { return players; }
    public void setPlayers(List<PlayerTeamAssignment> players) { this.players = players; }
    public Integer getTeamAScore() { return teamAScore; }
    public void setTeamAScore(Integer teamAScore) { this.teamAScore = teamAScore; }
    public Integer getTeamBScore() { return teamBScore; }
    public void setTeamBScore(Integer teamBScore) { this.teamBScore = teamBScore; }
}