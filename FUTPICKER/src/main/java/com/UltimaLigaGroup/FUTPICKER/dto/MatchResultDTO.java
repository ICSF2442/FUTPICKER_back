package com.UltimaLigaGroup.FUTPICKER.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MatchResultDTO {
    private Long id;
    private String name;
    private String location;
    private LocalDate matchDate;
    private String teamAColor;
    private String teamBColor;
    private Long mvpPlayerId;
    private String mvpPlayerName;
    private LocalDateTime playedAt;
    private Integer teamAScore;
    private Integer teamBScore;
    private Boolean finished;
    private List<MatchPlayerDTO> players;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public LocalDate getMatchDate() { return matchDate; }
    public void setMatchDate(LocalDate matchDate) { this.matchDate = matchDate; }
    public String getTeamAColor() { return teamAColor; }
    public void setTeamAColor(String teamAColor) { this.teamAColor = teamAColor; }
    public String getTeamBColor() { return teamBColor; }
    public void setTeamBColor(String teamBColor) { this.teamBColor = teamBColor; }
    public Long getMvpPlayerId() { return mvpPlayerId; }
    public void setMvpPlayerId(Long mvpPlayerId) { this.mvpPlayerId = mvpPlayerId; }
    public String getMvpPlayerName() { return mvpPlayerName; }
    public void setMvpPlayerName(String mvpPlayerName) { this.mvpPlayerName = mvpPlayerName; }
    public LocalDateTime getPlayedAt() { return playedAt; }
    public void setPlayedAt(LocalDateTime playedAt) { this.playedAt = playedAt; }
    public Integer getTeamAScore() { return teamAScore; }
    public void setTeamAScore(Integer teamAScore) { this.teamAScore = teamAScore; }
    public Integer getTeamBScore() { return teamBScore; }
    public void setTeamBScore(Integer teamBScore) { this.teamBScore = teamBScore; }
    public Boolean getFinished() { return finished; }
    public void setFinished(Boolean finished) { this.finished = finished; }
    public List<MatchPlayerDTO> getPlayers() { return players; }
    public void setPlayers(List<MatchPlayerDTO> players) { this.players = players; }
}