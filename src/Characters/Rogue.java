package Characters;

public class Rogue extends RPGCharacter {

    public Rogue() {
        super("",
                1,
                0,
                0,
                6,
                2,
                1,
                8,
                8*10,
                6+2,
                1);
    }

    @Override
    public void levelUp() {
        this.setVitality(this.getVitality()+3);
        this.setStrength(this.getStrength()+1);
        this.setDexterity(this.getDexterity()+4);
        this.setIntelligence(this.getIntelligence()+1);

        this.setHealth((this.getVitality()+3)*10);
        this.setArmorRating(this.getStrength()+ 1 + this.getDexterity() + 4);
        this.setElementalResistance(this.getIntelligence()+1);
    }
}
