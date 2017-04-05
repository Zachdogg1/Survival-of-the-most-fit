package inventory;



import com.badlogic.gdx.utils.Array;

/**
 * Created by 256233 on 2/23/2017.
 */
public class Slot {
    private Item item;

    private int amount;
    private Array<SlotListener> slotListners = new Array<SlotListener>();
    public Slot(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }
    public Boolean isEmpty(){
        return item == null || amount <=0;
    }
    public boolean add(Item item, int number)
    {
        if(this.item == item || this.item == null) {
            this.item = item;
            this.amount += number;
            notifyListeners();
            return true;
        }
        return false;
    }
    public boolean take(int amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            if (this.amount == 0) {
                item = null;
            }
            notifyListeners();
            return true;
        }

        return false;
    }
    public void addListener(SlotListener slotListener) {
        slotListners.add(slotListener);
    }
    public void removeListener(SlotListener slotListener) {
        slotListners.removeValue(slotListener, true);
    }
    private void notifyListeners() {
        for (SlotListener slotListener : slotListners) {
            slotListener.hasChanged(this);
        }

    }
    public Item getItem() {
        return item;
    }
    public int getAmount() {
        return amount;
    }
    @Override
    public String toString() {
        return "Slot[" + item + ":" + amount + "]";
    }
}
