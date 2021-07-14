package Characters;

public class Mage extends RPGCharacter {

    public Mage() {
        super("",
                1,
                0,
                0,
                1,
                1,
                8,
                5,
                5*10,
                1+1,
                8);
    }


    @Override
    public void levelUp() {
        this.setVitality(this.getVitality()+3);
        this.setStrength(this.getStrength()+1);
        this.setDexterity(this.getDexterity()+1);
        this.setIntelligence(this.getIntelligence()+5);

        this.setHealth((this.getVitality()+3)*10);
        this.setArmorRating(this.getStrength()+ 1 + this.getDexterity() + 1);
        this.setElementalResistance(this.getIntelligence()+5);
    }

}
