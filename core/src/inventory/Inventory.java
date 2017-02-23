package inventory;

import com.badlogic.gdx.utils.Array;

/**
 * Created by 256233 on 2/23/2017.
 */
public class Inventory {
    private Array<Slot> slots;
    public Inventory() {
        slots = new Array<Slot>(200);
        for (int i = 0; i < 200; i++) {
            slots.add(new Slot(null, 0));
        }
    }
    public int checkInv(Item item) {
        int amount = 0;

        for (Slot slot : slots) {
            if (slot.getItem() == item) {
                amount += slot.getAmount();
            }
        }

        return amount;
    }
    public boolean store(Item item, int amount) {
        Slot slot = firstSlotWithItem(item);
        if (slot != null){
            slot.add(item,amount);
            return true;
        } else{
            Slot emptyspot = firstSlotWithItem(null);
            if(emptyspot != null)
            {
                emptyspot.add(item, amount);
                return true;
            }
        }
        return false;
    }
    public Array<Slot> getSlots() {
        return slots;
    }
    private Slot firstSlotWithItem(Item item) {
        for (Slot slot : slots) {
            if (slot.getItem() == item) {
                return slot;
            }
        }

        return null;
    }
}
