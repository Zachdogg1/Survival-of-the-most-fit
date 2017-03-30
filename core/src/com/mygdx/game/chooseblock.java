package com.mygdx.game;
import buttons.Background;
import buttons.Button1;
import buttons.Button2;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;



/**
 * Created by 256233 on 2/21/2017.
 */
public class chooseblock implements Screen {
    private Game game;
    private Texture fill;
    private Texture fill2;
    private SpriteBatch load;
    private Stage stage;
    public Background background;
    public Button1 button1;
    public Button2 button2;

    public chooseblock(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        background = new Background();
        button1 = new Button1();
        button2 = new Button2();
        stage.addActor(background);
        stage.addActor(button1);
        stage.addActor(button2);
        render(0);
    }


    public void create(){

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(1920, 1080, true);
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
        stage.dispose();
    }
}
