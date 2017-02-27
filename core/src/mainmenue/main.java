package mainmenue;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;


/**
 * Created by 256233 on 2/27/2017.
 */
public class main implements Screen {
    private Game game;
    private Texture mainscreen;
    private SpriteBatch load;
    private Stage menu;
    private Viewport viewport;
    private OrthographicCamera camera;
    public main()
    {
        camera = new OrthographicCamera();
        viewport = new FitViewport(1920,1080);
        load = new SpriteBatch();
        menu = new Stage(viewport, load);
        mainscreen = new Texture("data/MainMenu.png");
    }
    @Override
    public void show() {

        load.begin();
        load.draw(mainscreen,0,0);

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {

        }
        load.end();
    }

    @Override
    public void render(float delta) {

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
