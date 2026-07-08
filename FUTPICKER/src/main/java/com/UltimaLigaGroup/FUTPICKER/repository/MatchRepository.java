package com.UltimaLigaGroup.FUTPICKER.repository;

import com.UltimaLigaGroup.FUTPICKER.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findAllByOrderByPlayedAtDesc();
}