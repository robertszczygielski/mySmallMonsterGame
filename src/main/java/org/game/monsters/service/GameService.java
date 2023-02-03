package org.game.monsters.service;

import org.game.monsters.dto.Dice;
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

        if (playerMonster == null && enemyMonster == null) {
            playerMonster = monsterService.pickupMonster();
            enemyMonster = monsterService.pickupMonster(playerMonster);
        }

        boolean continueGame = menuDispatcher();

        return continueGame;
    }

    private boolean menuDispatcher() {
        String playerChoice = menuService.showMenu().toUpperCase();
        if (playerChoice.equals("A")) rollDices();
        if (playerChoice.equals("B")) displayMyMonster();
        if (playerChoice.equals("C")) displayEnemyMonster();

        return !playerChoice.equals("X");
    }

    private void displayEnemyMonster() {
        System.out.println("===============================");
        System.out.println("Enemy monster is: ");
        System.out.println(enemyMonster);
    }

    private void displayMyMonster() {
        System.out.println("===============================");
        System.out.println("Your monster is: ");
        System.out.println(playerMonster);
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
