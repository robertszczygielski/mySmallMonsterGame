package org.game.monsters.service;

import java.util.Scanner;

public class MenuService {

    public String showMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Chose 'x' to exit: ");
        return keyboard.nextLine();
    }

}
