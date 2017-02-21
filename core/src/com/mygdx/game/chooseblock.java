package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import static com.badlogic.gdx.math.Interpolation.*;
/**
 * Created by 256233 on 2/21/2017.
 */
public class chooseblock implements Screen {
    private Game game;
    private Texture fill;
    private Texture fill2;
    private SpriteBatch load;
    public chooseblock(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        fill = new Texture("data/fill.jpg");
        fill2 = new Texture("data/filler.jpg");
        load = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
    load.begin();
    load.draw(fill,10,10);
    load.draw(fill2,500,500);
    load.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
