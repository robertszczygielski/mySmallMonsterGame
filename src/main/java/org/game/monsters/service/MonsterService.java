package org.game.monsters.service;

import org.game.monsters.configuration.MonsterConfiguration;
import org.game.monsters.dto.Monster;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import static org.game.monsters.utils.StringColors.ANSI_RED;
import static org.game.monsters.utils.StringColors.ANSI_RESET;

public class MonsterService {

    private final MonsterConfiguration monsterConfiguration = new MonsterConfiguration();

    public Monster pickupMonster() {
        List<Monster> monsters = monsterConfiguration.getMonsters();

        IntStream.range(0, monsters.size())
                .forEach(idx -> {
                             ANSI_RED.setColor();
                             System.out.println(idx + ") ");
                             ANSI_RESET.setColor();
                             System.out.println(monsters.get(idx));
                         }
                );
        Scanner keyboard = new Scanner(System.in);

        System.out.println();
        System.out.println("Pickup your Monster:");
        int playerChoice = keyboard.nextInt();

        return monsters.get(playerChoice);
    }

    public Monster pickupMonster(Monster reservedMonster) {
        List<Monster> monsters = monsterConfiguration.getMonsters();
        Random random = new Random();
        Monster chosenMonster = monsters.stream()
                .filter(monster -> !monster.equals(reservedMonster))
                .toList()
                .get(random.nextInt(monsters.size() - 1));
        return chosenMonster;
    }
}
