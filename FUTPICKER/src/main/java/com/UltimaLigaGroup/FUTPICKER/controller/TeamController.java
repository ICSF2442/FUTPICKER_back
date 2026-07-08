package com.UltimaLigaGroup.FUTPICKER.controller;

import com.UltimaLigaGroup.FUTPICKER.dto.TeamGenerationRequest;
import com.UltimaLigaGroup.FUTPICKER.dto.TeamGenerationResponse;
import com.UltimaLigaGroup.FUTPICKER.service.TeamBalancerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamBalancerService teamBalancerService;

    public TeamController(TeamBalancerService teamBalancerService) {
        this.teamBalancerService = teamBalancerService;
    }

    @PostMapping("/generate")
    public TeamGenerationResponse generate(@RequestBody TeamGenerationRequest request) {
        return teamBalancerService.generateTeams(request);
    }
}