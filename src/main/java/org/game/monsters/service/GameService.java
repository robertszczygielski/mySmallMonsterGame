package org.game.monsters.service;

import org.game.monsters.configuration.MonsterConfiguration;
import org.game.monsters.dto.Monster;

import java.util.List;

public class GameService {

    private final MonsterService monsterService = new MonsterService();
    private final MenuService menuService = new MenuService();

    private Monster playerMonster;
    private Monster enemyMonster;

    public boolean play() {

        playerMonster = monsterService.pickupMonster();
        String playerChoice = menuService.showMenu();

        System.out.println("You chose: " + playerMonster);

        if (playerChoice.equals("x")) return false;

        return true;
    }

}
