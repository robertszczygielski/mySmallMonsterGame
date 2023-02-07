package org.game.monsters.dto;

public enum DiceValueEnum {

    LIVE(0, "live"),
    ONE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3"),
    BITE(4, "bite"),
    ENERGY(5, "energy");

    private final int index;
    private final String symbol;

    DiceValueEnum(int index, String symbol) {
        this.index = index;
        this.symbol = symbol;
    }

    public static DiceValueEnum getByIndex(int index) {
        for (DiceValueEnum dve: values()) {
            if (dve.index == index) return dve;
        }
        throw new IllegalArgumentException("No index " + index + " found");
    }

    public int getIndex() {
        return index;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isVictoryPoint() {
        return this == ONE || this == TWO || this == THREE;
    }
}
