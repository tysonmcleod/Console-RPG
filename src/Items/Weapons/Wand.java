package Items.Weapons;

import Items.Item;
import Items.ItemType;
import Items.Slots.SlotType;

public class Wand extends Weapon{
    public Wand(ItemType type, String name, int requiredLevel, SlotType slotType, WeaponType weaponType, int damage, int attackSpeed) {
        super(type, name, requiredLevel, slotType, weaponType, damage, attackSpeed);
    }

    @Override
    public void viewStats() {

    }
}
