package com.UltimaLigaGroup.FUTPICKER.repository;

import com.UltimaLigaGroup.FUTPICKER.entity.RatingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RatingHistoryRepository extends JpaRepository<RatingHistory, Long> {
    List<RatingHistory> findByPlayerIdOrderByRecordedAtDesc(Long playerId);
}