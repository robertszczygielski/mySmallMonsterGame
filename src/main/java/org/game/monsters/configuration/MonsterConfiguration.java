package org.game.monsters.configuration;

import org.game.monsters.dto.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MonsterConfiguration {

    private List<Monster> monsters = new ArrayList<>();

    public MonsterConfiguration() {
        this.monsters.add(new Monster(UUID.randomUUID(), "Big Ant"));
        this.monsters.add(new Monster(UUID.randomUUID(), "Small Gorilla"));
    }

    public List<Monster> getMonsters() {
        return monsters;
    }
}
