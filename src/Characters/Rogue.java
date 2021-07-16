package Characters;

import Items.Slots.SlotType;

public class Rogue extends RPGCharacter {

    public Rogue() {
        super(CharacterType.Rogue,
                "",
                1,
                0,
                1.06,
                6,
                2,
                1,
                8,
                8*10,
                6+2,
                1);
    }


    // custom level up method for this specific character
    @Override
    public void levelUp(int i) {
        try{
            if (i < 1) {
                throw new IllegalArgumentException("Level must be greater than zero");
            }else{
                if(this.getWeaponHashMap().containsKey(SlotType.WeaponSlot)) {
                    this.setDamage(((this.getDamage() / (100.0 + (double) this.getDexterity())) * (100.0 + (double) this.getDexterity() + 4.0)));
                }else{
                    this.setDamage((((double) this.getDexterity() + 100.0 + 4.0) / 100.0));
                    }

                this.setLevel(this.getLevel()+1);

                this.setVitality(this.getVitality()+3);
                this.setStrength(this.getStrength()+1);
                this.setDexterity(this.getDexterity()+4);
                this.setIntelligence(this.getIntelligence()+1);

                this.setHealth((this.getVitality())*10);
                this.setArmorRating(this.getStrength() + this.getDexterity());
                this.setElementalResistance(this.getIntelligence());
            }
        }catch (IllegalArgumentException e){
            System.out.println("Level must be greater than 0");
        }
    }
}
