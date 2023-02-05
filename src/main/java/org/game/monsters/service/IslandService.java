package org.game.monsters.service;

import org.game.monsters.dto.Monster;

public class IslandService {

    private Monster occupyingMonster;

    public Monster getOccupyingMonster() {
        return occupyingMonster;
    }

    public void setOccupyingMonster(Monster occupyingMonster) {
        this.occupyingMonster = occupyingMonster;
    }

    public void resetIsland() {
        this.occupyingMonster = null;
    }
}
