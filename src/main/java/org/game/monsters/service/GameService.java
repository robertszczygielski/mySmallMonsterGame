package org.game.monsters.service;

import org.game.monsters.configuration.MonsterConfiguration;
import org.game.monsters.dto.Monster;

import java.util.List;

public class GameService {

    private final MonsterConfiguration monsterConfiguration = new MonsterConfiguration();
    private final MenuService menuService = new MenuService();

    public boolean play() {
        List<Monster> monsters = monsterConfiguration.getMonsters();

        for (Monster monster: monsters) {
            System.out.println(monster);
        }

        String playerChoice = menuService.showMenu();

        if (playerChoice.equals("x")) return false;

        return true;
    }

}
