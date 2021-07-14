package Functionality;

import Characters.*;


public class CreateCharacter {
    public static RPGCharacter createChar(int i){
        switch(i) {
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