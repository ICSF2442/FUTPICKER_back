// entity/MatchPlayer.java
package com.UltimaLigaGroup.FUTPICKER.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "match_players")
public class MatchPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 1)
    private Team team;

    public enum Team { A, B }

    public MatchPlayer() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Match getMatch() { return match; }
    public void setMatch(Match match) { this.match = match; }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
}