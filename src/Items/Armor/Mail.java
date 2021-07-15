package Items.Armor;

import Items.ItemType;
import Items.Slots.SlotType;

public class Mail extends Armor{
    public Mail(ItemType type, String name, int requiredLevel, SlotType slotType, ArmorType armorType, int extraDexterity, int extraStrength, int extraVitality, int extraIntelligence) {
        super(type, name, requiredLevel, slotType, armorType, extraDexterity, extraStrength, extraVitality, extraIntelligence);
    }

    @Override
    public void viewStats() {

    }
}
