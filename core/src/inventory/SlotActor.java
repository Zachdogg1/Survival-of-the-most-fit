package inventory;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by 256233 on 4/3/2017.
 */
public class SlotActor extends ImageButton implements SlotListener {
    private Slot slot;
    private Skin skin;
    public SlotActor(Skin skin, Slot slot) {
        super(createStyle(skin, slot));
        this.slot = slot;
        this.skin = skin;
        slot.addListener(this);
        SlotTooltip tooltip = new SlotTooltip(slot, skin);
        InventoryScreen.stage.addActor(tooltip);
        addListener(new TooltipListener(tooltip, true));
    }
    private static ImageButtonStyle createStyle(Skin skin, Slot slot) {
        TextureAtlas icons = LibgdxUtils.assets.get("icons/icons.atlas", TextureAtlas.class);
        TextureRegion image;
        if (slot.getItem() != null) {
            image = icons.findRegion(slot.getItem().getTextureRegion());
        }else {
            // we have a special "empty" region in our atlas file, which is just black
            image = icons.findRegion("nothing");
        }
        ImageButtonStyle style = new ImageButtonStyle(skin.get(ButtonStyle.class));
        style.imageUp = new TextureRegionDrawable(image);
        style.imageDown = new TextureRegionDrawable(image);

        return style;
    }

    @Override
    public void hasChanged(Slot slot) {
        setStyle(createStyle(skin, slot));
    }
    public Slot getSlot() {
        return slot;
    }
}
