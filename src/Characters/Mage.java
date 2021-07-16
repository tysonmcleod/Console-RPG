package Characters;

import Items.Armor.Armor;
import Items.Slots.Slot;
import Items.Weapons.Weapon;

import java.util.HashMap;

import static Items.Slots.SlotType.WeaponSlot;

public class Mage extends RPGCharacter {
    public Mage() {
        super(CharacterType.Mage,
                "",
                1,
                0,
                1,
                1,
                1,
                8,
                5,
                5*10,
                1+1,
                8
                );
    }


    // custom level up method for this specific character

    @Override
    public void levelUp(int i) {
        try
        {
            if (i < 1) {
                throw new IllegalArgumentException("Level must be greater than zero");
            }else{
                if (this.getWeaponHashMap().containsKey(WeaponSlot)) {
                this.setDamage(((this.getDamage() / (100 + this.getIntelligence())) * (100 + this.getIntelligence() + 5)));
                }else{
                    this.setDamage(this.getDamage() *(1+(this.getIntelligence()/100)));
                }
                this.setLevel(this.getLevel()+1);
                this.setVitality(this.getVitality()+3);
                this.setStrength(this.getStrength()+1);
                this.setDexterity(this.getDexterity()+1);
                this.setIntelligence(this.getIntelligence()+5);

                this.setHealth((this.getVitality())*10);
                this.setArmorRating(this.getStrength() + this.getDexterity());
                this.setElementalResistance(this.getIntelligence());
            }
        }catch(IllegalArgumentException e){
            System.out.println("Level must be greater than 0");
        }

    }
}
