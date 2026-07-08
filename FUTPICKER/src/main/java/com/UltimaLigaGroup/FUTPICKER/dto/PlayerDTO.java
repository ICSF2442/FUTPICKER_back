package com.UltimaLigaGroup.FUTPICKER.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerDTO {
    private Long id;
    private String name;
    private Integer rit;
    private Integer tec;
    private Integer def;
    private Integer rem;
    private Integer ovr;
    private String archetype;
    private Boolean isGoalkeeper;
    private String photo;


    public PlayerDTO() {}

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
    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }
}