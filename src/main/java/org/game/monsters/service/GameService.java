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
        Dice dice1 = new Dice();
        dice1.setDiceValue(DiceValueEnum.BITE);
        Dice dice2 = new Dice();
        dice2.setDiceValue(DiceValueEnum.ONE);
        dices.add(dice1);
        dices.add(dice2);

        dices.stream()
                .forEach(System.out::println);
    }

}
