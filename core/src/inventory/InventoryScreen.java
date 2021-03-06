package inventory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;



/**
 * Created by 256233 on 4/5/2017.
 */
public class InventoryScreen implements Screen {
    private InventoryActor inventoryActor;

    public static Stage stage;

    @Override
    public void show() {
        // create the stage and make it receive all input
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));

        DragAndDrop dragAndDrop = new DragAndDrop();
        inventoryActor = new InventoryActor(new Inventory(), dragAndDrop, skin);
        stage.addActor(inventoryActor);
    }

    @Override
    public void render(float delta) {
        // the screen will have a dark grey background colour
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        // show the inventory when any key is pressed
        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            inventoryActor.setVisible(true);
        }

        // handle all inputs and draw the whole UI
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
        dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
