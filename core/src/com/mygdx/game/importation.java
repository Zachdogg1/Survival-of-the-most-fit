package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
/**
 * Created by 256233 on 1/23/2017.
 */
public class importation extends ApplicationAdapter {
    private Texture dirt;
    private Texture tree;
    private Texture stone;
    private Music russiasong;
    private OrthographicCamera camera;
    private SpriteBatch groundtexture;
    private Rectangle dirtspace;
    @Override
    public void create(){
        dirt = new Texture(Gdx.files.internal("DarkDirt.jpg"));
        tree = new Texture(Gdx.files.internal("BigTree1.png"));
        stone = new Texture(Gdx.files.internal("download.jpg"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        russiasong = Gdx.audio.newMusic(Gdx.files.internal("russiasong.mp3"));
        russiasong.setLooping(true);
        russiasong.play();
        groundtexture = new SpriteBatch();
        dirtspace = new Rectangle();
        dirtspace.x = 800 / 2 - 64 / 2;
        dirtspace.y = 20;
        dirtspace.width = 64;
        dirtspace.height = 64;
    }
    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(dirt, dirtspace.x, dirtspace.y);
        batch.end();
        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            dirtspace.x = touchPos.x - 64 / 2;
        }
    }
}
