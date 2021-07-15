package Items;

import Items.Slots.SlotType;

public abstract class Item {
    // attributes
    private ItemType type;
    private String name;
    private int requiredLevel;
    private SlotType slotType;


    // getters and setters
    public ItemType getItemType() {
        return type;
    }

    public void setItemType(ItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    // constructor


    public Item(ItemType type, String name, int requiredLevel, SlotType slotType) {
        this.type = type;
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slotType = slotType;
    }

    public abstract void viewStats();
}
