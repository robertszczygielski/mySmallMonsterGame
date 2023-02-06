package org.game.monsters.utils;

public enum StringColors {

    ANSI_RESET("\u001B[0m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_RED("\u001B[31m"),
    ;

    private final String colorCode;

    StringColors(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColor() {
        System.out.println(this.getColorCode());
    }

}
