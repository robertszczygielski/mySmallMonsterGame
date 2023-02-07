package org.game.monsters.service;

import org.game.monsters.dto.Dice;
import org.game.monsters.dto.Monster;
import org.game.monsters.utils.StringColors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.game.monsters.utils.StringColors.*;

public class GameService {

    private final MonsterService monsterService = new MonsterService();
    private final MenuService menuService = new MenuService();
    private final DiceTowerService diceTowerService = new DiceTowerService();
    private final IslandService islandService = new IslandService();

    private Monster playerMonster;
    private Monster enemyMonster;

    private final int MIN_MONSTER_HP_TO_OCCUPY_THE_ISLAND = 10;

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
        if (playerChoice.equals("A")) {
            List<Dice> dices = rollDices().stream().sorted().collect(Collectors.toList());
            rerollDices(dices);
            showRolledDices(dices);
            enemyMonsterIslandMoves();
            useDices(dices);
        }
        if (playerChoice.equals("B")) displayMyMonster();
        if (playerChoice.equals("C")) displayEnemyMonster();
        if (playerChoice.equals("D")) takeTheIsland();
        if (playerChoice.equals("E")) leaveTheIsland();
        if (playerChoice.equals("F")) showTheIslandMonster();

        return !playerChoice.equals("X");
    }

    private void useDices(List<Dice> dices) {
        monsterService.addVictoryPoints(playerMonster, dices);
        ANSI_RED.setColor();
        System.out.print("---------------------------------------");
        ANSI_RESET.setColor();
        monsterService.addEnergyPoints(playerMonster, dices);
        if (!islandService.getOccupyingMonster().equals(playerMonster)) {
            ANSI_RED.setColor();
            System.out.print("---------------------------------------");
            ANSI_RESET.setColor();
            monsterService.addHealthPoints(playerMonster, dices);
        }
    }

    private void enemyMonsterIslandMoves() {
        if (islandService.getOccupyingMonster() == null) {
            islandService.setOccupyingMonster(enemyMonster);
        }
        if (enemyMonster.getHealthPoints() < MIN_MONSTER_HP_TO_OCCUPY_THE_ISLAND) {
            islandService.resetIsland();
            ANSI_RED.setColor();
            System.out.print("Enemy monster leaved the island, his name is ");
            ANSI_YELLOW.setColor();
            System.out.println(enemyMonster.getName());
            ANSI_RESET.setColor();
        }
    }

    private void showRolledDices(List<Dice> dices) {
        diceTowerService.showRolledDices(dices);
    }

    private List<Dice> rerollDices(List<Dice> dices) {
        int numbersOfReroll = 2;
        for (int i = 0; i < numbersOfReroll; i++) {
            System.out.println("Current dices: ");
            dices.stream()
                    .forEach(System.out::println);

            System.out.println(i + " reroll:" );
            System.out.println("Do you wont to reroll the dice? (Y/N): ");
            Scanner scanner = new Scanner(System.in);

            String playerChoice = scanner.nextLine().toUpperCase();
            if (playerChoice.equals("N")) return dices;

            IntStream.range(0, dices.size())
                    .forEach(idx -> {
                        System.out.println(idx + ") " + dices.get(idx));
                    });

            System.out.println("Pickup all, separate by coma (,): ");
            playerChoice = scanner.nextLine().toUpperCase();

            String [] choiceDice = playerChoice.replaceAll("\\s+", "").split(",");
            if (choiceDice.length == 0) {
                System.err.println("You do not have pickup dices");
                return dices;
            }

            List<Dice> dicesToReroll = Arrays.stream(choiceDice)
                    .map(diceIndex -> Integer.valueOf(diceIndex))
                    .map(diceIndex -> dices.get(diceIndex))
                    .collect(Collectors.toList());

            dicesToReroll.forEach(dice -> dices.remove(dice));

            List<Dice> newRolledDices = diceTowerService.roll(dicesToReroll);
            dices.addAll(newRolledDices);

        }
        return dices.stream().sorted().collect(Collectors.toList());
    }

    private void showTheIslandMonster() {
        System.out.println(islandService.getOccupyingMonster());
    }

    private void leaveTheIsland() {
        islandService.resetIsland();
    }

    private void takeTheIsland() {
        islandService.setOccupyingMonster(playerMonster);
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

    private List<Dice> rollDices() {
        List<Dice> dices = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            dices.add(new Dice());
        }

        List<Dice> diceList = diceTowerService.roll(dices);

        diceList.stream()
                .forEach(System.out::println);

        return dices;
    }

}
