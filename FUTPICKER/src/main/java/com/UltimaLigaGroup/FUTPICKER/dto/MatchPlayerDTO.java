package com.UltimaLigaGroup.FUTPICKER.dto;

public class MatchPlayerDTO {
    private Long playerId;
    private String name;
    private String team;
    private Integer goals;
    private Integer assists;

    public MatchPlayerDTO() {}

    public MatchPlayerDTO(Long playerId, String name, String team, Integer goals, Integer assists) {
        this.playerId = playerId;
        this.name = name;
        this.team = team;
        this.goals = goals;
        this.assists = assists;
    }

    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }
    public Integer getGoals() { return goals; }
    public void setGoals(Integer goals) { this.goals = goals; }
    public Integer getAssists() { return assists; }
    public void setAssists(Integer assists) { this.assists = assists; }
}