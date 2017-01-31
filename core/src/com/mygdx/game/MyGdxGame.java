package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;


public class MyGdxGame extends ApplicationAdapter {
	private Texture dirt;
	private Texture tree;
	private Texture stone;
	private int charnum;
	private Music russiasong;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Rectangle dirtspace;
    public static TiledMap map;
    public TiledMapRenderer tiledMapRenderer;
    public Texture character;

	@Override
	public void create () {
        map = new TmxMapLoader().load("data/map.tmx");
		dirt = new Texture("data/DarkDirt.jpg");
		tree = new Texture(("data/BigTree1.png"));
		stone = new Texture(("data/download.jpg"));
		charnum = randomgeneration.characters();

		if (0 == charnum) {
            character = new Texture("data/char1.png");
        }
		if (1 == charnum) {
            character = new Texture("data/char2.png");
        }
		if (2 == charnum) {
            character = new Texture("data/char3.png");
        }

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1920, 1080);
		batch = new SpriteBatch();

		dirtspace = new Rectangle();
		dirtspace.x = 800 / 2 - 64 / 2;
		dirtspace.y = 20;
		dirtspace.width = 32;
		dirtspace.height = 32;
	}

	@Override
	public void render () {

		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(character, dirtspace.x, dirtspace.y);
		batch.end();
		if(Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);

		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
