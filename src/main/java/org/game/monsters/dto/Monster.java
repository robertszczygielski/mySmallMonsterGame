package org.game.monsters.dto;

import java.util.Objects;
import java.util.UUID;

public class Monster {

    private UUID id;
    private String name;
    private Integer healthPoints;
    private Integer victoryPoints;
    private Integer energy;

    public Monster(UUID id,
                   String name) {
        this.id = id;
        this.name = name;
        this.healthPoints = 10;
        this.victoryPoints = 0;
        this.energy = 0;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(Integer victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return Objects.equals(id, monster.id) && Objects.equals(name, monster.name) &&
                Objects.equals(healthPoints, monster.healthPoints) &&
                Objects.equals(victoryPoints, monster.victoryPoints) &&
                Objects.equals(energy, monster.energy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, healthPoints, victoryPoints, energy);
    }

    @Override
    public String toString() {
        return "Monster: " +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\nhealthPoints=" + healthPoints +
                "\nvictoryPoints=" + victoryPoints +
                "\nenergy=" + energy;
    }
}
