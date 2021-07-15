package Characters;

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

    @Override
    public void levelUp(int i) {
        try{
            if (i < 1) {
                throw new IllegalArgumentException("Level must be greater than zero");
            }else{
                if(this.getDamage()>1) {
                    this.setDamage(((this.getDamage() / (100 + this.getDexterity())) * (100 + this.getDexterity() + 5)));
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
