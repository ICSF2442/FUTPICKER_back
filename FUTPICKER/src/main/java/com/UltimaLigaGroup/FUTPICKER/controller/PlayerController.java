package com.UltimaLigaGroup.FUTPICKER.controller;

import com.UltimaLigaGroup.FUTPICKER.dto.PlayerDTO;
import com.UltimaLigaGroup.FUTPICKER.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<PlayerDTO> getAll() {
        return playerService.getAll();
    }

    @GetMapping("/{id}")
    public PlayerDTO getById(@PathVariable Long id) {
        return playerService.getById(id);
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> create(@RequestBody PlayerDTO dto) {
        PlayerDTO created = playerService.create(dto);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public PlayerDTO update(@PathVariable Long id, @RequestBody PlayerDTO dto) {
        return playerService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        playerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/bulk")
    public List<PlayerDTO> bulkUpsert(@RequestBody List<PlayerDTO> players) {
        return playerService.bulkUpsert(players);
    }

    @PostMapping("/import")
    public List<PlayerDTO> importPlayers(@RequestBody PlayerImportRequest request) {
        return playerService.importFromFile(request);
    }
}

