package inventory;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

/**
 * Created by 256233 on 4/5/2017.
 */
public class SlotTarget extends DragAndDrop.Target {
    private Slot targetSlot;

    public SlotTarget(SlotActor actor) {
        super(actor);
        targetSlot = actor.getSlot();
        getActor().setColor(Color.LIGHT_GRAY);
    }

    @Override
    public boolean drag(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
        Slot payloadSlot = (Slot) payload.getObject();

        // in case we drag something over this target, we highlight it a bit
        getActor().setColor(Color.WHITE);

        // returning true means that this is a valid target
        return true;
    }

    @Override
    public void drop(DragAndDrop.Source source, DragAndDrop.Payload payload, float x, float y, int pointer) {
        // we already handle all of this in dragStop in the Source
    }

    @Override
    public void reset(DragAndDrop.Source source, DragAndDrop.Payload payload) {
        getActor().setColor(Color.LIGHT_GRAY);
    }

}
