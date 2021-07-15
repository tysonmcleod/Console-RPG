package Items.Weapons;

import Items.Item;
import Items.ItemType;
import Items.Slots.SlotType;

public abstract class Weapon extends Item {
    private WeaponType weaponType;
    private double damage;
    private double attackSpeed;
    private double damagePerSecond;


    // setters and getters
    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getDamagePerSecond() {
        return damagePerSecond;
    }

    public void setDamagePerSecond(int damagePerSecond) {
        this.damagePerSecond = damagePerSecond;
    }

    public Weapon(ItemType type, String name, int requiredLevel, SlotType slotType, WeaponType weaponType, double damage, double attackSpeed) {
        super(type, name, requiredLevel, slotType);
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.damagePerSecond = damage*attackSpeed;
    }
}
