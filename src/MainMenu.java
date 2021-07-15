import Characters.*;
import Functionality.CreateCharacter;
import Items.Armor.Armor;
import Items.Armor.ArmorType;
import Items.Armor.Cloth;
import Items.Armor.Plate;
import Items.Item;
import Items.ItemType;
import Items.Slots.BodySlot;
import Items.Slots.SlotType;
import Items.Weapons.Sword;
import Items.Weapons.WeaponType;

import java.util.Scanner;
import static Functionality.Utils.clearScreen;


public class MainMenu {

    public static void gameMenu() {

        // A very simple menu
        System.out.println("Welcome \n 1\t Mage \n 2\t Ranger \n 3\t Rogue \n 4\t Warrior ");

        int chooseChar = 0;
        int choice;
        Scanner scanner = new Scanner(System.in);

        CharacterType type = null;
        do {
            System.out.println("Please choose your character");
            while (!scanner.hasNextInt()) {
                System.out.println("Choose a number between 1-4");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Mage");
                    chooseChar = 1;
                }
                case 2 -> {
                    System.out.println("Ranger");
                    chooseChar = 1;
                }
                case 3 -> {
                    System.out.println("Rogue");
                    chooseChar = 1;
                }
                case 4 -> {
                    System.out.println("Warrior");
                    chooseChar = 1;
                }
                default -> System.out.print("Invalid choice");
            }
        } while (chooseChar != 1);


        // createCharacter with choice

        System.out.println("Choose a name for your character");
        scanner.nextLine();
        String charName = scanner.nextLine();

        RPGCharacter character = CreateCharacter.createChar(choice);
        assert character != null;
        character.setName(charName);
        clearScreen();

        System.out.println("Welcome " + charName + "!");


        int quit = 0;

        do {
            System.out.println("See stats(1) - Explore(2) - Attack(3) - Equip(4) - Quit(5)");
            while (!scanner.hasNextInt()) {
                System.out.println("Choose a number between 1-5");
                scanner.next();
            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> character.displayAttributes();
                case 2 -> System.out.println("Explore");
                case 3 -> {
                    System.out.println("Attack");
                    character.levelUp(1);
                }
                case 4 -> {
                    Plate bodyPlate = new Plate(ItemType.Armor, "Body Plate", 1, SlotType.BodySlot, ArmorType.Plate,10, 10, 10, 10 ) {
                    };
                    try{
                        character.EquipArmor(bodyPlate);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }


                    Sword sword = new Sword(ItemType.Weapon, "Golden sword", 1, SlotType.WeaponSlot, WeaponType.Sword, 100, 10);
                    try{
                        character.EquipWeapon(sword);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                }
                case 5 -> {
                    System.out.println("Quit");
                    quit = 1;
                }
                default -> System.out.print("Invalid choice");
            }

        } while (quit != 1);
        scanner.close();

    }


}