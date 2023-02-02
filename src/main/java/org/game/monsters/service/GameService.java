package org.game.monsters.service;

import org.game.monsters.configuration.MonsterConfiguration;
import org.game.monsters.dto.Dice;
import org.game.monsters.dto.DiceValueEnum;
import org.game.monsters.dto.Monster;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private final MonsterService monsterService = new MonsterService();
    private final MenuService menuService = new MenuService();
    private final DiceTowerService diceTowerService = new DiceTowerService();

    private Monster playerMonster;
    private Monster enemyMonster;

    public boolean play() {

        playerMonster = monsterService.pickupMonster();
        enemyMonster = monsterService.pickupMonster(playerMonster);
        String playerChoice = menuService.showMenu();
        rollDices();

        System.out.println("You chose: " + playerMonster);
        System.out.println("Enemy monster: " + enemyMonster);

        if (playerChoice.equals("x")) return false;

        return true;
    }

    private void rollDices() {
        List<Dice> dices = new ArrayList<>();

        for (int i=0; i<6; i++) {
            dices.add(new Dice());
        }

        List<Dice> diceList = diceTowerService.roll(dices);

        diceList.stream()
                .forEach(System.out::println);

    }

}
