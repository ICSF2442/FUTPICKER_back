package com.UltimaLigaGroup.FUTPICKER.repository;

import com.UltimaLigaGroup.FUTPICKER.entity.MatchPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MatchPlayerRepository extends JpaRepository<MatchPlayer, Long> {
    List<MatchPlayer> findByMatchId(Long matchId);
    List<MatchPlayer> findByPlayerId(Long playerId);
}