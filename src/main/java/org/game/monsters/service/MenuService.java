package org.game.monsters.service;

import java.util.Scanner;

import static org.game.monsters.utils.StringColors.ANSI_GREEN;
import static org.game.monsters.utils.StringColors.ANSI_RESET;

public class MenuService {

    public String showMenu(boolean monsterOnIsland,
                           boolean playerMonsterOnIsland) {
        Scanner keyboard = new Scanner(System.in);
        ANSI_GREEN.setColor();
        System.out.println("Chose 'a' to use dice tower: ");
        System.out.println("Chose 'b' show my monster: ");
        System.out.println("Chose 'c' show enemy monster: ");
        if (!monsterOnIsland) System.out.println("Chose 'd' go to the island: ");
        if (playerMonsterOnIsland) System.out.println("Chose 'e' leave the island: ");
        if (monsterOnIsland) System.out.println("Chose 'f' show monster on the island: ");
        System.out.println("Chose 'x' to exit: ");
        ANSI_RESET.setColor();
        return keyboard.nextLine();
    }

}
