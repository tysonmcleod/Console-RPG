package Items;

import Characters.RPGCharacter;
import Functionality.CreateCharacter;
import Functionality.Exceptions.InvalidArmorException;
import Functionality.Exceptions.InvalidWeaponException;
import Items.Armor.Armor;
import Items.Armor.ArmorType;
import Items.Armor.Cloth;
import Items.Armor.Plate;
import Items.Slots.SlotType;
import Items.Slots.WeaponSlot;
import Items.Weapons.Axe;
import Items.Weapons.Bow;
import Items.Weapons.WeaponType;
import org.junit.jupiter.api.Test;

import static Items.Slots.SlotType.BodySlot;
import static Items.Slots.SlotType.WeaponSlot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ItemTest {
    // weapon level too high
    @Test
    public void testHighLevelWeapon_invalid_shouldPass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        Axe axe = new Axe(ItemType.Weapon, "Common Axe", 2, SlotType.WeaponSlot, WeaponType.Axe, 7, 1.1);
        Throwable exception = assertThrows(InvalidWeaponException.class, ()-> warrior.EquipWeapon(axe), "Your level is too low");
    }

    // armor level too high
    @Test
    public void testHighLevelArmor_invalid_shouldPass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        Plate bodyPlate = new Plate(ItemType.Armor, "Common Plate Body Armor", 2, SlotType.BodySlot, ArmorType.Plate, 0,1, 2, 0);
        Throwable exception = assertThrows(InvalidArmorException.class, ()-> warrior.EquipArmor(bodyPlate), "Your level is too low");
    }

    // wrong weapon type
    @Test
    public void testWrongWeaponType_invalid_shouldPass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        Bow bow = new Bow(ItemType.Weapon, "Common Bow", 1, SlotType.WeaponSlot, WeaponType.Bow, 12, 0.8);
        Throwable exception = assertThrows(InvalidWeaponException.class, ()-> warrior.EquipWeapon(bow), "Incorrect weapon type");
    }

    // wrong armor type
    @Test
    public void testWrongArmorType_invalid_shouldPass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        Cloth testClothHead = new Cloth(ItemType.Armor, "Common Cloth Head Armor", 1, SlotType.HeadSlot, ArmorType.Cloth, 0, 0, 1, 5);
        Throwable exception = assertThrows(InvalidArmorException.class, ()-> warrior.EquipArmor(testClothHead), "Incorrect weapon type");
    }

    // check weapon is equipped
    @Test
    public void weaponCorrectlyEquipped_valid_shouldPass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        Axe axe = new Axe(ItemType.Weapon, "Common Axe", 1, SlotType.WeaponSlot, WeaponType.Axe, 7, 1.1);
        try{
            warrior.EquipWeapon(axe);
            assertEquals(true, warrior.getWeaponHashMap().containsKey(WeaponSlot));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    // check armor is equipped
    @Test
    public void armorCorrectlyEquipped_valid_shouldPass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        Plate bodyPlate = new Plate(ItemType.Armor, "Common Plate Body Armor", 1, SlotType.BodySlot, ArmorType.Plate, 0,1, 2, 0);
        try{
            warrior.EquipArmor(bodyPlate);
            assertEquals(true, warrior.getArmorHashMap().containsKey(BodySlot));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // calculate DPS no weapon
    @Test
    public void dpsAtStartingLevel_valid_shouldPass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        double num = 1 * 1.05;
        assertEquals(num, warrior.getDamage(),0);

    }

    // TODO
    // fix calculations with doubles

    // calculate dps with weapon
    @Test
    public void dpsWithWeapon_valid_shouldPass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        Axe axe = new Axe(ItemType.Weapon, "Common Axe", 1, SlotType.WeaponSlot, WeaponType.Axe, 7, 1.1);
        try{
            warrior.EquipWeapon(axe);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        assertEquals(Math.round((7*1.1)*(1+((5+1)/100))), Math.round(warrior.getDamage()));

    }

    // calculate dps with weapon and armor
    @Test
    public void dpsWithWeaponAndArmor_valid_shouldPass(){
        RPGCharacter warrior = CreateCharacter.createChar(4);
        Plate bodyPlate = new Plate(ItemType.Armor, "Common Plate Body Armor", 1, SlotType.BodySlot, ArmorType.Plate, 0,1, 2, 0);
        Axe axe = new Axe(ItemType.Weapon, "Common Axe", 1, SlotType.WeaponSlot, WeaponType.Axe, 7, 1.1);


        try{
            warrior.EquipArmor(bodyPlate);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
         try{
         warrior.EquipWeapon(axe);
         }catch(Exception e){
         System.out.println(e.getMessage());
         }
        assertEquals(Math.round((7*1.1)*(1+((5+1)/100))), Math.round(warrior.getDamage()));

    }
}
