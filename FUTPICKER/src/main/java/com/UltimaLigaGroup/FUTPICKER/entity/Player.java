package com.UltimaLigaGroup.FUTPICKER.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

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

    @Column(name = "is_goalkeeper", nullable = false)
    private Boolean isGoalkeeper = false;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Player() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
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
    public Boolean getIsGoalkeeper() { return isGoalkeeper; }
    public void setIsGoalkeeper(Boolean isGoalkeeper) { this.isGoalkeeper = isGoalkeeper; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}