package com.UltimaLigaGroup.FUTPICKER.controller;

import com.UltimaLigaGroup.FUTPICKER.dto.*;
import com.UltimaLigaGroup.FUTPICKER.service.MatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public MatchResultDTO confirmMatch(@RequestBody ConfirmMatchRequest request) {
        return matchService.confirmMatch(request);
    }

    @GetMapping
    public List<MatchResultDTO> getAll() {
        return matchService.getAll();
    }

    @GetMapping("/{id}")
    public MatchResultDTO getById(@PathVariable Long id) {
        return matchService.getById(id);
    }

    @PutMapping("/{id}/score")
    public MatchResultDTO updateScore(@PathVariable Long id, @RequestBody UpdateScoreRequest request) {
        return matchService.updateScore(id, request);
    }

    @GetMapping("/player/{playerId}/record")
    public PlayerRecordDTO getPlayerRecord(@PathVariable Long playerId) {
        return matchService.getPlayerRecord(playerId);
    }
}