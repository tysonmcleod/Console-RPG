package Characters;

public class Warrior extends RPGCharacter {

    public Warrior() {
        super("",
                1,
                0,
                0,
                2,
                5,
                1,
                10,
                10*10,
                2+5,
                1);
    }

    @Override
    public void levelUp() {
        this.setVitality(this.getVitality()+5);
        this.setStrength(this.getStrength()+3);
        this.setDexterity(this.getDexterity()+2);
        this.setIntelligence(this.getIntelligence()+1);

        this.setHealth((this.getVitality()+5)*10);
        this.setArmorRating(this.getStrength()+ 3 + this.getDexterity() + 2);
        this.setElementalResistance(this.getIntelligence()+1);
    }

}
