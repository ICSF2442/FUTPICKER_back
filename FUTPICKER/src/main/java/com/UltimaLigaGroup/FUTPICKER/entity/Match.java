package com.UltimaLigaGroup.FUTPICKER.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @Column(name = "match_date")
    private LocalDate matchDate;

    @Column(name = "team_a_color")
    private String teamAColor;

    @Column(name = "team_b_color")
    private String teamBColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mvp_player_id")
    private Player mvp;

    @Column(name = "played_at")
    private LocalDateTime playedAt;

    @Column(name = "team_a_score")
    private Integer teamAScore;

    @Column(name = "team_b_score")
    private Integer teamBScore;

    @Column(nullable = false)
    private Boolean finished = false;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MatchPlayer> matchPlayers = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.playedAt = LocalDateTime.now();
        if (this.matchDate == null) {
            this.matchDate = LocalDate.now();
        }
    }

    public Match() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public LocalDate getMatchDate() { return matchDate; }
    public void setMatchDate(LocalDate matchDate) { this.matchDate = matchDate; }
    public String getTeamAColor() { return teamAColor; }
    public void setTeamAColor(String teamAColor) { this.teamAColor = teamAColor; }
    public String getTeamBColor() { return teamBColor; }
    public void setTeamBColor(String teamBColor) { this.teamBColor = teamBColor; }
    public Player getMvp() { return mvp; }
    public void setMvp(Player mvp) { this.mvp = mvp; }
    public LocalDateTime getPlayedAt() { return playedAt; }
    public void setPlayedAt(LocalDateTime playedAt) { this.playedAt = playedAt; }
    public Integer getTeamAScore() { return teamAScore; }
    public void setTeamAScore(Integer teamAScore) { this.teamAScore = teamAScore; }
    public Integer getTeamBScore() { return teamBScore; }
    public void setTeamBScore(Integer teamBScore) { this.teamBScore = teamBScore; }
    public List<MatchPlayer> getMatchPlayers() { return matchPlayers; }
    public void setMatchPlayers(List<MatchPlayer> matchPlayers) { this.matchPlayers = matchPlayers; }
    public Boolean getFinished() { return finished; }
    public void setFinished(Boolean finished) { this.finished = finished; }
}