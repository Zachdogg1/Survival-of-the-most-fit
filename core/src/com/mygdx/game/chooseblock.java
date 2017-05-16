package com.mygdx.game;
import buttons.*;
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
import inven2.use;

import static com.mygdx.game.MyGdxGame.b;


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
    public Button3 button3;
    public Button4 button4;
    public Button5 button5;
    public Button6 button6;
    public Button7 button7;
    public Button8 button8;
    public Button9 button9;
    public Button10 button10;
    public Button11 button11;
    public Button12 button12;
    public Button13 button13;
    public Button14 button14;
    public Button15 button15;
    public Button16 button16;
    public Button17 button17;
    public Button18 button18;
    public Button19 button19;

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
        button3 = new Button3();
        button4 = new Button4();
        button5 = new Button5();
        button6 = new Button6();
        button7 = new Button7();
        button8 = new Button8();
        button9 = new Button9();
        button10 = new Button10();
        button11 = new Button11();
        button12 = new Button12();
        button13 = new Button13();
        button14 = new Button14();
        button15 = new Button15();
        button16 = new Button16();
        button17 = new Button17();
        button18 = new Button18();
        button19 = new Button19();
        stage.addActor(background);
        stage.addActor(button1);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
        stage.addActor(button5);
        stage.addActor(button6);
        stage.addActor(button7);
        stage.addActor(button8);
        stage.addActor(button9);
        stage.addActor(button10);
        stage.addActor(button11);
        stage.addActor(button12);
        stage.addActor(button13);
        stage.addActor(button14);
        stage.addActor(button15);
        stage.addActor(button16);
        stage.addActor(button17);
        stage.addActor(button18);
        stage.addActor(button19);
        render(0);
    }


    public void create(){

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        if(Gdx.input.isKeyPressed(Input.Keys.A)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)&&Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)&&Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){


        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)&&Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)&&Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.TAB))
        {


        }

        if(Gdx.input.isKeyPressed(Input.Keys.BACKSPACE)){





        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
        {

        }
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
