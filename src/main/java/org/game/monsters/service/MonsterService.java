package org.game.monsters.service;

import org.game.monsters.configuration.MonsterConfiguration;
import org.game.monsters.dto.Dice;
import org.game.monsters.dto.Monster;
import org.game.monsters.utils.StringColors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

import static org.game.monsters.utils.StringColors.*;

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

    public void addEnergyPoints(Monster monster, List<Dice> diceList) {
        int energyFromDices = Math.toIntExact(
                diceList.stream()
                        .filter(dice -> dice.getDiceValue().isEnergy())
                        .count()
        );
        int currentEnergy = monster.getEnergy();

        System.out.print("Energy before adding: ");
        ANSI_GREEN.setColorSemLine();
        System.out.print(currentEnergy);
        ANSI_RESET.setColor();
        System.out.print("Energy to add: ");
        ANSI_YELLOW.setColorSemLine();
        System.out.println(energyFromDices);

        monster.setEnergy(currentEnergy + energyFromDices);

        ANSI_RESET.setColor();
        System.out.print("Monster " + monster.getName() + " hes now ");
        ANSI_GREEN.setColorSemLine();
        System.out.print(monster.getEnergy());
        ANSI_RESET.setColorSemLine();
        System.out.println(" Energy");

    }

    public void addVictoryPoints(Monster monster,
                                 List<Dice> diceList) {
        List<Dice> ones = new ArrayList<>();
        List<Dice> twos = new ArrayList<>();
        List<Dice> threes = new ArrayList<>();

        diceList.stream()
                .filter(dice -> dice.getDiceValue().isVictoryPoint())
                .forEach(dice -> {
                    switch (dice.getDiceValue()) {
                        case ONE -> ones.add(dice);
                        case TWO -> twos.add(dice);
                        case THREE -> threes.add(dice);
                    }
                });

        int countedOnes = sumVictoryPoints(ones);
        int countedTwos = sumVictoryPoints(twos);
        int countedThrees = sumVictoryPoints(threes);

        int allCountedVictoryPoints = countedOnes + countedTwos + countedThrees;
        int currentVictoryPoints = monster.getVictoryPoints();

        System.out.print("Victory Points before adding: ");
        ANSI_GREEN.setColorSemLine();
        System.out.print(currentVictoryPoints);
        ANSI_RESET.setColor();
        System.out.print("Victory Points to add: ");
        ANSI_YELLOW.setColorSemLine();
        System.out.println(allCountedVictoryPoints);

        monster.setVictoryPoints(currentVictoryPoints + allCountedVictoryPoints);

        ANSI_RESET.setColor();
        System.out.print("Monster " + monster.getName() + " hes now ");
        ANSI_GREEN.setColorSemLine();
        System.out.print(monster.getVictoryPoints());
        ANSI_RESET.setColorSemLine();
        System.out.println(" Victory Points");
    }

    private int sumVictoryPoints(List<Dice> diceList) {
        if (diceList == null || diceList.size() < 3) return 0;

        int basicVictoryPoint = Integer.parseInt(
                diceList.stream().findFirst().get().getDiceValue().getSymbol()
        );
        int victoryPoint = 0;

        if (diceList.size() < 4) victoryPoint += basicVictoryPoint;
        if (diceList.size() == 4) victoryPoint += basicVictoryPoint;
        if (diceList.size() == 5) victoryPoint += basicVictoryPoint;
        if (diceList.size() == 6) victoryPoint += basicVictoryPoint;

        return victoryPoint;
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
