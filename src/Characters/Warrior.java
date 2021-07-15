package Characters;

import static Items.Slots.SlotType.WeaponSlot;

public class Warrior extends RPGCharacter {

    public Warrior() {
        super(CharacterType.Warrior,
                "",
                1,
                0,
                1.05,
                2,
                5,
                1,
                10,
                10*10,
                2+5,
                1);
    }

    @Override
    public void levelUp(int i) {
        try {
            //sSystem.out.println("Printing the hash map");
            //System.out.println(this.weaponHashMap);
            if (i < 1) {
                throw new IllegalArgumentException("Level must be greater than zero");
            } else {
                if (this.getWeaponHashMap().containsKey(WeaponSlot)) {
                    this.setDamage(this.getDamage() / (100 + this.getStrength()) * (100 + this.getStrength() + 3));
                }else{
                    this.setDamage((this.getDamage() *(1+this.getStrength()/100)));
                }
                this.setLevel(this.getLevel() + 1);

                this.setVitality(this.getVitality() + 5);
                this.setStrength(this.getStrength() + 3);
                this.setDexterity(this.getDexterity() + 2);
                this.setIntelligence(this.getIntelligence() + 1);

                this.setHealth((this.getVitality()) * 10);
                this.setArmorRating(this.getStrength() + this.getDexterity());
                this.setElementalResistance(this.getIntelligence());
            }
        }catch (IllegalArgumentException e){
            System.out.println("Level must be greater than 0");
        }

    }

}
