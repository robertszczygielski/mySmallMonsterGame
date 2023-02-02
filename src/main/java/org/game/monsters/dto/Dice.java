package org.game.monsters.dto;

import java.util.Objects;

public class Dice implements Comparable<Dice> {

    DiceValueEnum diceValue;

    public DiceValueEnum getDiceValue() {
        return diceValue;
    }

    public void setDiceValue(DiceValueEnum diceValue) {
        this.diceValue = diceValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return diceValue == dice.diceValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diceValue);
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceValue=" + diceValue +
                '}';
    }

    @Override
    public int compareTo(Dice o) {
        if (this.diceValue.getIndex() < o.diceValue.getIndex()) return -1;
        if (this.diceValue.getIndex() > o.diceValue.getIndex()) return 1;
        return 0;
    }
}
