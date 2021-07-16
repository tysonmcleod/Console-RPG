package Functionality;

import Characters.*;

// Create character depending on user choice
public class CreateCharacter {
    public static RPGCharacter createChar(int choice){
        switch(choice) {
            case 1 -> {
                return new Mage();
            }
            case 2 -> {
                return new Ranger();
            }
            case 3 -> {
                return new Rogue();
            }
            case 4 -> {
                return new Warrior();
            }
            default -> {
                return null;
            }
        }
    }
}