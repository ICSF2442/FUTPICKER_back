package com.UltimaLigaGroup.FUTPICKER.dto;

import java.util.List;

public class ConfirmMatchRequest {
    private String name;
    private String location;
    private String matchDate; // ISO format "yyyy-MM-dd", optional - defaults to today
    private String teamAColor;
    private String teamBColor;
    private List<PlayerTeamAssignment> players;
    private Integer teamAScore;
    private Integer teamBScore;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getMatchDate() { return matchDate; }
    public void setMatchDate(String matchDate) { this.matchDate = matchDate; }
    public String getTeamAColor() { return teamAColor; }
    public void setTeamAColor(String teamAColor) { this.teamAColor = teamAColor; }
    public String getTeamBColor() { return teamBColor; }
    public void setTeamBColor(String teamBColor) { this.teamBColor = teamBColor; }
    public List<PlayerTeamAssignment> getPlayers() { return players; }
    public void setPlayers(List<PlayerTeamAssignment> players) { this.players = players; }
    public Integer getTeamAScore() { return teamAScore; }
    public void setTeamAScore(Integer teamAScore) { this.teamAScore = teamAScore; }
    public Integer getTeamBScore() { return teamBScore; }
    public void setTeamBScore(Integer teamBScore) { this.teamBScore = teamBScore; }
}