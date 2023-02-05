package org.game.monsters.service;

import org.game.monsters.dto.Dice;
import org.game.monsters.dto.DiceValueEnum;

import java.util.List;
import java.util.Random;

public class DiceTowerService {

    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_RESET = "\u001B[0m";
    private final int DICE_SIZE = 6;

    public List<Dice> roll(final List<Dice> diceList) {
        Random random = new Random();
        return diceList.stream()
                .peek(dice -> {
                    int numb = random.nextInt(DICE_SIZE);
                    dice.setDiceValue(DiceValueEnum.getByIndex(numb));
                })
                .sorted()
                .toList();
    }

    public void showRolledDices(List<Dice> dices) {
        System.out.println(ANSI_YELLOW);
        dices.forEach(System.out::println);
        System.out.println(ANSI_RESET);
    }
}
