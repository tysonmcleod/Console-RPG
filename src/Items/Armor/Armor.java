package Items.Armor;

import Items.Item;
import Items.ItemType;
import Items.Slots.SlotType;

public abstract class Armor extends Item {
    private ArmorType armorType;
    private int extraDexterity;
    private int extraStrength;
    private int extraVitality;
    private int extraIntelligence;


    // getters and setters

    public int getExtraDexterity() {
        return extraDexterity;
    }

    public void setExtraDexterity(int extraDexterity) {
        this.extraDexterity = extraDexterity;
    }

    public int getExtraStrength() {
        return extraStrength;
    }

    public void setExtraStrength(int extraStrength) {
        this.extraStrength = extraStrength;
    }

    public int getExtraVitality() {
        return extraVitality;
    }

    public void setExtraVitality(int extraVitality) {
        this.extraVitality = extraVitality;
    }

    public int getExtraIntelligence() {
        return extraIntelligence;
    }

    public void setExtraIntelligence(int extraIntelligence) {
        this.extraIntelligence = extraIntelligence;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }


    public Armor(ItemType type, String name, int requiredLevel, SlotType slotType, ArmorType armorType, int extraDexterity, int extraStrength, int extraVitality, int extraIntelligence) {
        super(type, name, requiredLevel, slotType);
        this.armorType = armorType;
        this.extraDexterity = extraDexterity;
        this.extraStrength = extraStrength;
        this.extraVitality = extraVitality;
        this.extraIntelligence = extraIntelligence;
    }
}
