package Items.Slots;

public class Slot {
    private SlotType type;

    // getters and setters
    public SlotType getType() {
        return type;
    }

    public void setType(SlotType type) {
        this.type = type;
    }

     // constructor
    public Slot(SlotType type) {
        this.type = type;
    }
}
