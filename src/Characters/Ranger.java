package Characters;

import static Items.Slots.SlotType.WeaponSlot;

public class Ranger extends RPGCharacter {

    public Ranger() {
        super(CharacterType.Ranger,
                "",
                1,
                0,
                1,
                7,
                1,
                1,
                8,
                8*10,
                8+1,
                1);
    }

    // custom level up method for this specific character
    @Override
    public void levelUp(int i) {
        try{
            if (i < 1) {
                throw new IllegalArgumentException("Level must be greater than zero");
            }else{
                if (this.getWeaponHashMap().containsKey(WeaponSlot)) {
                    this.setDamage(((this.getDamage() / (100 + this.getDexterity())) * (100 + this.getDexterity() + 5)));
                }else{
                    this.setDamage(this.getDamage()*(1+(this.getDexterity()/100)));
                }
                if(this.getDamage() == 0){
                    this.setDamage(1);
                }
                this.setLevel(this.getLevel()+1);

                this.setVitality(this.getVitality()+2);
                this.setStrength(this.getStrength()+1);
                this.setDexterity(this.getDexterity()+5);
                this.setIntelligence(this.getIntelligence()+1);

                this.setHealth((this.getVitality())*10);
                this.setArmorRating(this.getStrength()+ this.getDexterity());
                this.setElementalResistance(this.getIntelligence());
            }
        }catch (IllegalArgumentException e){
            System.out.println("Level must be greater than zero");
        }
    }
}
