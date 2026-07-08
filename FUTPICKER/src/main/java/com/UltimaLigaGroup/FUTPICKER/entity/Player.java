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
    private Integer defending;

    @Column(nullable = false)
    private Integer physical;

    @Column(nullable = false)
    private Integer attack;

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

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getDefending() { return defending; }
    public void setDefending(Integer defending) { this.defending = defending; }

    public Integer getPhysical() { return physical; }
    public void setPhysical(Integer physical) { this.physical = physical; }

    public Integer getAttack() { return attack; }
    public void setAttack(Integer attack) { this.attack = attack; }

    public Boolean getIsGoalkeeper() { return isGoalkeeper; }
    public void setIsGoalkeeper(Boolean isGoalkeeper) { this.isGoalkeeper = isGoalkeeper; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}