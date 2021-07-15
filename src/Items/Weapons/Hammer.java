package Items.Weapons;

import Items.Item;
import Items.ItemType;
import Items.Slots.SlotType;

public class Hammer extends Weapon{
    public Hammer(ItemType type, String name, int requiredLevel, SlotType slotType, WeaponType weaponType, int damage, int attackSpeed) {
        super(type, name, requiredLevel, slotType, weaponType, damage, attackSpeed);
    }

    @Override
    public void viewStats() {

    }
}
