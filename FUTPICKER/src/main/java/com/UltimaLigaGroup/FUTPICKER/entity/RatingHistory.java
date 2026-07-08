package com.UltimaLigaGroup.FUTPICKER.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rating_history")
public class RatingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(nullable = false)
    private Integer rit;
    @Column(nullable = false)
    private Integer tec;
    @Column(nullable = false)
    private Integer def;
    @Column(nullable = false)
    private Integer rem;
    @Column(nullable = false)
    private Integer ovr;
    private String archetype;

    @Column(name = "recorded_at")
    private LocalDateTime recordedAt;

    @PrePersist
    protected void onCreate() { this.recordedAt = LocalDateTime.now(); }

    public RatingHistory() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public Integer getRit() { return rit; }
    public void setRit(Integer rit) { this.rit = rit; }
    public Integer getTec() { return tec; }
    public void setTec(Integer tec) { this.tec = tec; }
    public Integer getDef() { return def; }
    public void setDef(Integer def) { this.def = def; }
    public Integer getRem() { return rem; }
    public void setRem(Integer rem) { this.rem = rem; }
    public Integer getOvr() { return ovr; }
    public void setOvr(Integer ovr) { this.ovr = ovr; }
    public String getArchetype() { return archetype; }
    public void setArchetype(String archetype) { this.archetype = archetype; }
    public LocalDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }
}