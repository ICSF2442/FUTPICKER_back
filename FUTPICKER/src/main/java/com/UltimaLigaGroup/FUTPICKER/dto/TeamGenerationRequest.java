package com.UltimaLigaGroup.FUTPICKER.dto;

import java.util.List;
import java.util.Map;

public class TeamGenerationRequest {
    private List<Long> playerIds;
    private Map<Long, String> lockedAssignments; // playerId -> "A" or "B"

    public List<Long> getPlayerIds() { return playerIds; }
    public void setPlayerIds(List<Long> playerIds) { this.playerIds = playerIds; }
    public Map<Long, String> getLockedAssignments() { return lockedAssignments; }
    public void setLockedAssignments(Map<Long, String> lockedAssignments) { this.lockedAssignments = lockedAssignments; }
}