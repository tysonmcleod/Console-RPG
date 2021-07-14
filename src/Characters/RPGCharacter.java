package Characters;

public abstract class RPGCharacter {

    /*
      A character's attributes
    */
    private String name;
    private int level;
    private int exp;
    private int damage;

    // primary attributes
    private int strength;
    private int dexterity;
    private int intelligence;
    private int vitality;

    // secondary attributes
    private int health;
    private int armorRating;
    private int elementalResistance;

    /*
        Getters and setters
    */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }

    public int getElementalResistance() {
        return elementalResistance;
    }

    public void setElementalResistance(int elementalResistance) {
        this.elementalResistance = elementalResistance;
    }



    /*
        Constructor
    */

    public RPGCharacter(String name, int level, int exp, int damage, int dexterity, int strength, int intelligence, int vitality, int health, int armorRating, int elementalResistance){
        this.name = name;
        this.level = level;
        this.exp = exp;
        this.damage = damage;
        this.dexterity = dexterity;
        this.strength = strength;
        this.intelligence = intelligence;
        this.vitality = vitality;
        this.health = health;
        this.armorRating = armorRating;
        this.elementalResistance = elementalResistance;
    }








    /*
     Character related methods
     */


    // method to display attributes
    public void displayAttributes(){
        System.out.println("Name: " + this.getName());
        System.out.println("Level: " + this.getLevel());
        System.out.println("Exp: " + this.getExp());
        System.out.println("Health: " + this.getHealth());
        System.out.println("--- Stats ---");
        System.out.println("Damage: " + this.getDamage());
        System.out.println("Vitality: " + this.getVitality());
        System.out.println("Intelligence: " + this.getIntelligence());
        System.out.println("Strength: " + this.getStrength());
        System.out.println("Dexterity: " + this.getDexterity());
        System.out.println("Elemental resistance: " + this.getElementalResistance());
    }


   /*
     Abstract methods to be implemented by characters
     */


    // method to level up
    public abstract void levelUp();
}