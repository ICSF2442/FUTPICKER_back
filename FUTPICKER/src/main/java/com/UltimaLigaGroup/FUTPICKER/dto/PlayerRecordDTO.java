package com.UltimaLigaGroup.FUTPICKER.dto;

public class PlayerRecordDTO {
    private Long playerId;
    private String name;
    private int wins;
    private int losses;
    private int draws;

    public PlayerRecordDTO() {}

    public PlayerRecordDTO(Long playerId, String name, int wins, int losses, int draws) {
        this.playerId = playerId;
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
    }

    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getWins() { return wins; }
    public void setWins(int wins) { this.wins = wins; }
    public int getLosses() { return losses; }
    public void setLosses(int losses) { this.losses = losses; }
    public int getDraws() { return draws; }
    public void setDraws(int draws) { this.draws = draws; }
}