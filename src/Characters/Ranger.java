package Characters;

public class Ranger extends RPGCharacter {

    public Ranger() {
        super("",
                1,
                0,
                0,
                7,
                1,
                1,
                8,
                8*10,
                8+1,
                1);
    }

    @Override
    public void levelUp() {
        this.setVitality(this.getVitality()+2);
        this.setStrength(this.getStrength()+1);
        this.setDexterity(this.getDexterity()+5);
        this.setIntelligence(this.getIntelligence()+1);

        this.setHealth((this.getVitality()+2)*10);
        this.setArmorRating(this.getStrength()+ 1 + this.getDexterity() + 5);
        this.setElementalResistance(this.getIntelligence()+1);
    }

}
