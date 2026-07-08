package com.UltimaLigaGroup.FUTPICKER.service;

import com.UltimaLigaGroup.FUTPICKER.dto.PlayerDTO;
import com.UltimaLigaGroup.FUTPICKER.dto.PlayerImportRequest;
import com.UltimaLigaGroup.FUTPICKER.entity.Player;
import com.UltimaLigaGroup.FUTPICKER.entity.RatingHistory;
import com.UltimaLigaGroup.FUTPICKER.exception.ResourceNotFoundException;
import com.UltimaLigaGroup.FUTPICKER.repository.PlayerRepository;
import com.UltimaLigaGroup.FUTPICKER.repository.RatingHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final RatingHistoryRepository ratingHistoryRepository;

    public PlayerService(PlayerRepository playerRepository, RatingHistoryRepository ratingHistoryRepository) {
        this.playerRepository = playerRepository;
        this.ratingHistoryRepository = ratingHistoryRepository;
    }

    public List<PlayerDTO> getAll() {
        return playerRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PlayerDTO getById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found: " + id));
        return toDTO(player);
    }

    public PlayerDTO create(PlayerDTO dto) {
        Player player = new Player();
        applyDtoToEntity(dto, player);
        Player saved = playerRepository.save(player);
        return toDTO(saved);
    }

    public PlayerDTO update(Long id, PlayerDTO dto) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found: " + id));

        // snapshot current values before overwriting
        snapshotHistory(player);

        applyDtoToEntity(dto, player);
        Player saved = playerRepository.save(player);
        return toDTO(saved);
    }

    public void delete(Long id) {
        if (!playerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Player not found: " + id);
        }
        playerRepository.deleteById(id);
    }

    // Bulk upsert by name - used for the initial JSON load and later rating refreshes
    public List<PlayerDTO> bulkUpsert(List<PlayerDTO> dtos) {
        return dtos.stream().map(dto -> {
            Player player = playerRepository.findByName(dto.getName())
                    .orElseGet(Player::new);

            if (player.getId() != null) {
                snapshotHistory(player);
            }

            applyDtoToEntity(dto, player);
            return toDTO(playerRepository.save(player));
        }).collect(Collectors.toList());
    }

    private void snapshotHistory(Player player) {
        RatingHistory history = new RatingHistory();
        history.setPlayer(player);
        history.setRit(player.getRit());
        history.setTec(player.getTec());
        history.setDef(player.getDef());
        history.setRem(player.getRem());
        history.setOvr(player.getOvr());
        history.setArchetype(player.getArchetype());
        ratingHistoryRepository.save(history);
    }

    private void applyDtoToEntity(PlayerDTO dto, Player player) {
        player.setName(dto.getName());
        player.setRit(dto.getRit());
        player.setTec(dto.getTec());
        player.setDef(dto.getDef());
        player.setRem(dto.getRem());
        player.setOvr(dto.getOvr());
        player.setArchetype(dto.getArchetype());
        player.setIsGoalkeeper(dto.getIsGoalkeeper() != null ? dto.getIsGoalkeeper() : false);
    }

    private PlayerDTO toDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setRit(player.getRit());
        dto.setTec(player.getTec());
        dto.setDef(player.getDef());
        dto.setRem(player.getRem());
        dto.setOvr(player.getOvr());
        dto.setArchetype(player.getArchetype());
        dto.setIsGoalkeeper(player.getIsGoalkeeper());
        return dto;
    }

    public List<PlayerDTO> importFromFile(PlayerImportRequest request) {
        return bulkUpsert(request.getPlayers());
    }
}