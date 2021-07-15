package Characters;

public class Warrior extends RPGCharacter {

    public Warrior() {
        super(CharacterType.Warrior,
                "",
                1,
                0,
                1,
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

            if (i < 1) {
                throw new IllegalArgumentException("Level must be greater than zero");
            } else {
                if (this.getDamage() > 1) {
                    this.setDamage(this.getDamage() / (100 + this.getStrength()) * (100 + this.getStrength() + 3));
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
