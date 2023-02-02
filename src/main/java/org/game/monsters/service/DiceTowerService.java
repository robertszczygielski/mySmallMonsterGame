package org.game.monsters.service;

import org.game.monsters.dto.Dice;
import org.game.monsters.dto.DiceValueEnum;

import java.util.List;
import java.util.Random;

public class DiceTowerService {

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

}
