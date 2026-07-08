package com.UltimaLigaGroup.FUTPICKER.dto;

public class UpdateScoreRequest {
    private Integer teamAScore;
    private Integer teamBScore;

    public Integer getTeamAScore() { return teamAScore; }
    public void setTeamAScore(Integer teamAScore) { this.teamAScore = teamAScore; }
    public Integer getTeamBScore() { return teamBScore; }
    public void setTeamBScore(Integer teamBScore) { this.teamBScore = teamBScore; }
}