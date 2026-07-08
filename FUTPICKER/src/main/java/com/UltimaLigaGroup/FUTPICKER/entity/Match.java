// entity/Match.java
package com.UltimaLigaGroup.FUTPICKER.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "played_at")
    private LocalDateTime playedAt;

    @Column(name = "team_a_score")
    private Integer teamAScore;

    @Column(name = "team_b_score")
    private Integer teamBScore;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MatchPlayer> matchPlayers = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.playedAt = LocalDateTime.now();
    }

    public Match() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getPlayedAt() { return playedAt; }
    public void setPlayedAt(LocalDateTime playedAt) { this.playedAt = playedAt; }

    public Integer getTeamAScore() { return teamAScore; }
    public void setTeamAScore(Integer teamAScore) { this.teamAScore = teamAScore; }

    public Integer getTeamBScore() { return teamBScore; }
    public void setTeamBScore(Integer teamBScore) { this.teamBScore = teamBScore; }

    public List<MatchPlayer> getMatchPlayers() { return matchPlayers; }
    public void setMatchPlayers(List<MatchPlayer> matchPlayers) { this.matchPlayers = matchPlayers; }
}