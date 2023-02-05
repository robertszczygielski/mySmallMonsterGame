package org.game.monsters.service;

import java.util.Scanner;

public class MenuService {

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_GREEN = "\u001B[32m";

    public String showMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(ANSI_GREEN);
        System.out.println("Chose 'a' to use dice tower: ");
        System.out.println("Chose 'b' show my monster: ");
        System.out.println("Chose 'c' show enemy monster: ");
        System.out.println("Chose 'd' go to the island: ");
        System.out.println("Chose 'e' leave the island: ");
        System.out.println("Chose 'f' show monster on the island: ");
        System.out.println("Chose 'x' to exit: ");
        System.out.println(ANSI_RESET);
        return keyboard.nextLine();
    }

}
