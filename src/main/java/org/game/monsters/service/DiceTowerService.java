package org.game.monsters.service;

import org.game.monsters.dto.Dice;
import org.game.monsters.dto.DiceValueEnum;

import java.util.List;
import java.util.Random;

import static org.game.monsters.utils.StringColors.ANSI_RESET;
import static org.game.monsters.utils.StringColors.ANSI_YELLOW;

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

    public void showRolledDices(List<Dice> dices) {
        ANSI_YELLOW.setColor();
        dices.forEach(System.out::println);
        ANSI_RESET.setColor();
    }
}
