package com.UltimaLigaGroup.FUTPICKER.dto;

import java.util.List;

public class TeamGenerationResponse {
    private List<PlayerDTO> teamA;
    private List<PlayerDTO> teamB;
    private double teamAScore;
    private double teamBScore;

    public TeamGenerationResponse() {}

    public TeamGenerationResponse(List<PlayerDTO> teamA, List<PlayerDTO> teamB, double teamAScore, double teamBScore) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamAScore = teamAScore;
        this.teamBScore = teamBScore;
    }

    public List<PlayerDTO> getTeamA() { return teamA; }
    public void setTeamA(List<PlayerDTO> teamA) { this.teamA = teamA; }
    public List<PlayerDTO> getTeamB() { return teamB; }
    public void setTeamB(List<PlayerDTO> teamB) { this.teamB = teamB; }
    public double getTeamAScore() { return teamAScore; }
    public void setTeamAScore(double teamAScore) { this.teamAScore = teamAScore; }
    public double getTeamBScore() { return teamBScore; }
    public void setTeamBScore(double teamBScore) { this.teamBScore = teamBScore; }
}