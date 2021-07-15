package Characters;

import Functionality.Exceptions.InvalidArmorException;
import Functionality.Exceptions.InvalidWeaponException;
import Items.Armor.Armor;
import Items.Armor.ArmorType;
import Items.Slots.SlotType;
import Items.Weapons.Weapon;
import Items.Weapons.WeaponType;
import java.lang.Math;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public abstract class RPGCharacter {
    /*
          A character's attributes
    */
    protected CharacterType type;
    protected String name;
    protected int level;
    protected int exp;
    protected double damage;

    // primary attributes
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int vitality;

    // secondary attributes
    protected int health;
    protected int armorRating;
    protected int elementalResistance;

    // equipment

    // TODO
    // use single item slot

    protected Map<SlotType, Armor> armorHashMap = new HashMap<SlotType, Armor>();
    protected Map<SlotType, Weapon> weaponHashMap = new HashMap<SlotType, Weapon>();

    /*
        Getters and setters
    */

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

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

    public double getDamage(){
        return damage;
    }

    public void setDamage(double damage){
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

    public Map<SlotType, Armor> getArmorHashMap() {
        return armorHashMap;
    }

    public void setArmorHashMap(HashMap<SlotType, Armor> armorHashMap) {
        this.armorHashMap = armorHashMap;
    }

    public Map<SlotType, Weapon> getWeaponHashMap() {
        return weaponHashMap;
    }

    public void setWeaponHashMap(HashMap<SlotType, Weapon> weaponHashMap) {
        this.weaponHashMap = weaponHashMap;
    }

    /*
        Constructor
    */

    public RPGCharacter(CharacterType type, String name, int level, int exp, double damage, int dexterity, int strength, int intelligence, int vitality, int health, int armorRating, int elementalResistance){
        this.type = type;
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
     Character Armor related methods
     */

    // TODO:
    // move to functionality:
    // create exceptions
    // create EquipItem
    public void EquipArmor(Armor armor) throws InvalidArmorException {

        if(!this.checkCorrectArmorType(armor.getArmorType())){
            throw new InvalidArmorException("Incorrect armor type");
        } else if (armor.getRequiredLevel() > this.getLevel()) {
            throw new InvalidArmorException("Your level is too low");
        } else {
            if(armorHashMap.containsKey(armor.getSlotType())){
                System.out.println("Removing: "+ armorHashMap.get(armor.getSlotType()).getName());
                this.removeArmorStats(armor);
            }
            armorHashMap.put(armor.getSlotType(), armor);
            System.out.println("You added " + armor.getArmorType() + ": " + armor.getName());
            this.addArmorStats(armor);
        }
    }


    public boolean checkCorrectArmorType(ArmorType armorType){

        CharacterType type = this.getType();

        switch (type){
            case Mage:
                if(armorType == ArmorType.Cloth){
                    return true;
                }
                break;
            case Ranger:
            case Rogue:
                if(armorType == ArmorType.Leather || armorType == ArmorType.Mail){
                    return true;
                }
                break;
            case Warrior:
                if(armorType == ArmorType.Mail  || armorType == ArmorType.Plate){
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    public void addArmorStats(Armor armor){
        this.setStrength(this.getStrength()+armor.getExtraStrength());
        this.setDexterity(this.getDexterity()+armor.getExtraDexterity());
        this.setIntelligence(this.getIntelligence()+armor.getExtraIntelligence());
        this.setVitality(this.getVitality()+armor.getExtraVitality());

        this.setHealth(this.getVitality()*10);
        this.setArmorRating(this.getStrength()+this.getDexterity());
        this.setElementalResistance(this.getIntelligence());

    }

    public void removeArmorStats(Armor armor){
        this.setStrength(this.getStrength()-armor.getExtraStrength());
        this.setDexterity(this.getDexterity()-armor.getExtraDexterity());
        this.setIntelligence(this.getIntelligence()-armor.getExtraIntelligence());
        this.setVitality(this.getVitality()-armor.getExtraVitality());

        this.setHealth(this.getVitality()*10);
        this.setArmorRating(this.getStrength()+this.getDexterity());
        this.setElementalResistance(this.getIntelligence());

    }



 /*
     Character Weapon related methods
     */

    public void EquipWeapon(Weapon weapon) throws InvalidWeaponException {

        if(!this.checkCorrectWeaponType(weapon.getWeaponType())){
            throw new InvalidWeaponException("Incorrect weapon type");
        } else if (weapon.getRequiredLevel() > this.getLevel()) {
            throw new InvalidWeaponException("Your level is too low");
        } else {
            if(weaponHashMap.containsKey(weapon.getSlotType())){
                System.out.println("Removing: "+ weaponHashMap.get(weapon.getSlotType()).getName());
                this.removeWeaponStats(weapon);
            }
            weaponHashMap.put(weapon.getSlotType(), weapon);
            System.out.println("You added " + weapon.getWeaponType() + ": " + weapon.getName());
            this.addWeaponStats(weapon);
        }
    }

    public boolean checkCorrectWeaponType(WeaponType weaponType){

        CharacterType type = this.getType();

        switch (type){
            case Mage:
                if(weaponType == WeaponType.Staff || weaponType == WeaponType.Wand){
                    return true;
                }
                break;
            case Ranger:
                if(weaponType == WeaponType.Bow){
                    return true;
                }
                break;
            case Rogue:
                if(weaponType == WeaponType.Dagger || weaponType == WeaponType.Sword){
                    return true;
                }
                break;
            case Warrior:
                if(weaponType == WeaponType.Axe  || weaponType == WeaponType.Hammer || weaponType == WeaponType.Sword){
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    public void addWeaponStats(Weapon weapon){

        //double totalPrimaryAttributes = (this.getStrength() + this.getVitality() + this.getIntelligence() + this.getDexterity());
        double weaponDamagePerSecond = weapon.getDamagePerSecond();
        double totalPrimaryAttributes;
        double result;

        CharacterType type = this.getType();
        switch (type) {
            case Warrior -> {
                totalPrimaryAttributes = this.getStrength();
                result = weaponDamagePerSecond * (1.0 + (totalPrimaryAttributes/100.0));
                this.setDamage(result);
            }
            case Rogue, Ranger -> {
                totalPrimaryAttributes = this.getDexterity();
                result = weaponDamagePerSecond*  (1.0 + (totalPrimaryAttributes/100.0));
                this.setDamage(result);
            }
            case Mage -> {
                totalPrimaryAttributes = this.getIntelligence();
                result = weaponDamagePerSecond * (1.0 + (totalPrimaryAttributes/100.0));
                this.setDamage(result);
            }
            default -> this.setDamage(1);
        }
        //this.setDamage(weapon.getDamagePerSecond() * (1+(totalPrimaryAttributes/100)));
    }

    public void removeWeaponStats(Weapon weapon){
        this.setDamage(1);
    }


    // method to display attributes
    public void displayAttributes(){
        System.out.println(this.getType() + ": " + this.getName());
        System.out.println("Level: " + this.getLevel());
        System.out.println("Exp: " + this.getExp());
        System.out.println("--- Stats ---");
        System.out.println("Strength: " + this.getStrength());
        System.out.println("Dexterity: " + this.getDexterity());
        System.out.println("Intelligence: " + this.getIntelligence());
        System.out.println("Vitality: " + this.getVitality());
        System.out.println("Health: " + this.getHealth());
        System.out.println("Armor rating: " + this.getArmorRating());
        System.out.println("Elemental resistance: " + this.getElementalResistance());
        if(this.weaponHashMap.containsKey(SlotType.WeaponSlot) || this.getDamage() > 5){
            System.out.println("Damage: " + Math.ceil(this.getDamage()));
        }else{
            System.out.println("Damage: " + this.getDamage());

        }
    }


   /*
     Abstract methods to be implemented by characters
     */


    // This is the function that is implemented by Mage.java , Warrior.java, Rogue.java, Ranger.java and updates
    // everything (strength, dexterity, intelligence ...) except for the level and damage using the same functions



    // method to level up
    public abstract void levelUp(int i);


   }

