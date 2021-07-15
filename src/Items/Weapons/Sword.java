package Items.Weapons;

import Items.Item;
import Items.ItemType;
import Items.Slots.SlotType;

public class Sword extends Weapon{
    public Sword(ItemType type, String name, int requiredLevel, SlotType slotType, WeaponType weaponType, int damage, int attackSpeed) {
        super(type, name, requiredLevel, slotType, weaponType, damage, attackSpeed);
    }

    @Override
    public void viewStats() {

    }
}
