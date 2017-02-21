package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import static com.badlogic.gdx.math.Interpolation.*;


public class MyGdxGame extends Game {
	private Texture dirt;
	private Texture tree;
	private Texture stone;
	private int charnum;
	private Music russiasong;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Rectangle dirtspace;
    public static TiledMap map, newmap;
    public OrthogonalTiledMapRenderer tiledMapRenderer;
    public Texture character;
    private Sprite mainpc;
	private Game game;

	public MyGdxGame() {
		game = this;

	}

	@Override
	public void create () { //initialising all variables

        map = new TmxMapLoader().load("data/map1.tmx");
        newmap = map;
		dirt = new Texture("data/DarkDirt.jpg");
		tree = new Texture(("data/BigTree1.png"));
		stone = new Texture(("data/download.jpg"));
		charnum = randomgeneration.characters();
		tiledMapRenderer = new OrthogonalTiledMapRenderer(newmap);

		if (0 == charnum) {
            character = new Texture("data/char1.png");
        }
		if (1 == charnum) {
            character = new Texture("data/char2.png");
        }
		if (2 == charnum) {
            character = new Texture("data/char3.png");
        }
		mainpc = new Sprite(character);
		mainpc.setPosition(1000,900);
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
	//main running of the game
	public void render () {
		super.render();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//setting camera and rendering map
		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();

		camera.position.set(mainpc.getX() + mainpc.getWidth()/2, mainpc.getY() + mainpc.getHeight()/2, 20);

		tiledMapRenderer.getBatch().begin();
		//movement
		if(Gdx.input.isKeyPressed(Keys.A)){
				if(mainpc.getX() > 0 && collisiondet.willcollide(mainpc.getX()-2, mainpc.getY()) == false)
				mainpc.translateX(-2f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
				if((mainpc.getX() + 32 < 6400)&& collisiondet.willcollide(mainpc.getX()+2, mainpc.getY()) == false)
				mainpc.translateX(2f);


		}
		if(Gdx.input.isKeyPressed(Keys.S)){
				if(mainpc.getY() > 0 && collisiondet.willcollide(mainpc.getX(), mainpc.getY()-2) == false)
				mainpc.translateY(-2f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
				if(mainpc.getY() + 32 < 3616 && collisiondet.willcollide(mainpc.getX(), mainpc.getY()+2) == false)
				mainpc.translateY(2f);
		}
		if(Gdx.input.isKeyPressed(Keys.TAB))
		{
			setScreen(new chooseblock(game));

		}
		if(Gdx.input.isKeyPressed(Keys.ENTER)){
		editMap(mainpc.getX(),mainpc.getY(), 0);
		}
		if(Gdx.input.isKeyPressed(Keys.BACKSPACE)){
			changeblock.modify(mainpc.getX(),mainpc.getY());
		}
		batch.setProjectionMatrix(camera.combined);
		mainpc.draw(tiledMapRenderer.getBatch());


		tiledMapRenderer.getBatch().end();
	}

	public void editMap(float posx, float posy, int blocktype){

		int x = Math.round(posx/32);
		int y = Math.round(posy/32);
		TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) map.getLayers().get(0)).getCell(blocktype,0);
		//((TiledMapTileLayer) newmap.getLayers().get("Tile Layer 2")).getCell(x,y).setTile((newmap.getTileSets().getTileSet(tilesetname)).getTile(blocktype));
		((TiledMapTileLayer) newmap.getLayers().get("Tile Layer 2")).setCell(x,y,cell);


	}
	@Override
	public void dispose () {
		batch.dispose();

	}

}
