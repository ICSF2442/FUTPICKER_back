package com.UltimaLigaGroup.FUTPICKER.dto;

import java.util.List;

public class PlayerImportRequest {
    private String updatedAt;
    private Integer count;
    private List<PlayerDTO> players;

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
    public Integer getCount() { return count; }
    public void setCount(Integer count) { this.count = count; }
    public List<PlayerDTO> getPlayers() { return players; }
    public void setPlayers(List<PlayerDTO> players) { this.players = players; }
}