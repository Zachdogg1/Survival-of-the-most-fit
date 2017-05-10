package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inven2.BasicInven;
import inven2.Starttiems;
import inven2.Tool;
import inven2.use;
import inventory.InventoryScreen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;


public class MyGdxGame extends Game {
	private ShapeRenderer shape;
	private Texture dirt;
	private Texture tree;
	private Texture stone;
	Thread t1;
	private int charnum;
	private Music russiasong;
	public  SpriteBatch batch;
	private int currentitem;
	public AudioPlayer musse;
	public static void setRequired(Tool tool) {
		required = tool;
	}

	public static Tool required;
	public static OrthographicCamera getCamera() {
		return camera;
	}

	private static OrthographicCamera camera;
	private Rectangle dirtspace;
    public static TiledMap map, newmap;
    public OrthogonalTiledMapRenderer tiledMapRenderer;
    public Texture character;
    private Sprite mainpc;
	private Game game;
    private long timeSince;
	public static BasicInven getB() {
		return b;
	}
    public static int itemCoolDown = 3000;
	public static BasicInven b;
	public static int blocktype;
    int lastsong;
	public MyGdxGame() {
		game = this;

	}

	@Override
	public void create () { //initialising all variables

		currentitem = 0;
		b = new BasicInven();
		b.start();
		required = b.starttiems.wood;
        map = new TmxMapLoader().load("data/map1.tmx");
        newmap = map;
        blocktype = 0;
		dirt = new Texture("data/DarkDirt.jpg");
		tree = new Texture(("data/BigTree1.png"));
		stone = new Texture(("data/download.jpg"));
		charnum = randomgeneration.characters();
		tiledMapRenderer = new OrthogonalTiledMapRenderer(newmap);
		Healthbar.reset();
		shape = new ShapeRenderer();
        timeSince = System.currentTimeMillis();
		if (0 == charnum) {
            character = new Texture("data/char1.png");
        }
		if (1 == charnum) {
            character = new Texture("data/char2.png");
        }
		if (2 == charnum) {
            character = new Texture("data/char3.png");
        }
		charnum = randomgeneration.music();
		charnum = randomgeneration.music();

		if (0 == charnum) {
			musse = new AudioPlayer("data/music/Far Away.mp3");
		}
		if (1 == charnum) {
			musse = new AudioPlayer("data/music/Staystrong.mp3");

		}
		if (2 == charnum) {

			musse = new AudioPlayer("data/music/Codered.mp3");
		}
		if(3 == charnum)
		{

			musse = new AudioPlayer("data/music/Rimraid.mp3");
		}

        lastsong = charnum;
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
		t1 = new Thread(musse);
		t1.start();
	}
	public static void changetype(int change)
	{
		blocktype = change;

	}

	@Override
	//main running of the game
	public void render () {
		super.render();


		if(!musse.song) {

			charnum = randomgeneration.music();

			if (0 == charnum) {
				if(lastsong == 0)
				{
					lastsong = 1;
					musse.setInput("data/music/Staystrong.mp3");

				}
				else {
					lastsong = 0;
					musse.setInput("data/music/Far Away.mp3");
				}


			}
			if (1 == charnum) {
				if(lastsong == 1)
				{
					lastsong = 2;
					musse.setInput("data/music/Codered.mp3");
				}
				else {
					lastsong = 1;
					musse.setInput("data/music/Staystrong.mp3");
				}
			}
			if (2 == charnum) {
				if(lastsong == 2)
				{
					lastsong = 3;
					musse.setInput("data/music/Rimraid.mp3");
				}
				else {
					lastsong = 2;
					musse.setInput("data/music/Codered.mp3");
				}
			}
			if(3 == charnum)
			{
				if(lastsong == 3)
				{
					lastsong = 0;
					musse.setInput("data/music/Far Away.mp3");
				}
				else {
					lastsong = 3;
					musse.setInput("data/music/Rimraid.mp3");
				}
			}
			System.out.println("I GOT HERE");
			musse.song = true;
			t1 = new Thread(musse);
			t1.start();

		}
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//setting camera and rendering map
		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		Healthbar.runeachtime();
		camera.position.set(mainpc.getX() + mainpc.getWidth()/2, mainpc.getY() + mainpc.getHeight()/2, 20);

		tiledMapRenderer.getBatch().begin();


		//movement
		if(Gdx.input.isKeyPressed(Keys.A)){
				if(mainpc.getX() > 0 && collisiondet.willcollide(mainpc.getX()-2, mainpc.getY()) == false)
				mainpc.translateX(-2f);
		}
		if(Gdx.input.isKeyPressed(Keys.A)&&Gdx.input.isKeyPressed(Keys.CONTROL_LEFT)){
			if(mainpc.getX() > 0 && collisiondet.willcollide(mainpc.getX()-2, mainpc.getY()) == false){
				mainpc.translateX(-2f);
			Healthbar.food -= .005;
		}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)){
				if((mainpc.getX() + 32 < 6400)&& collisiondet.willcollide(mainpc.getX()+2, mainpc.getY()) == false)
				mainpc.translateX(2f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)&&Gdx.input.isKeyPressed(Keys.CONTROL_LEFT)){
			if((mainpc.getX() + 32 < 6400)&& collisiondet.willcollide(mainpc.getX()+2, mainpc.getY()) == false){
				mainpc.translateX(2f);
			Healthbar.food -= .05;
		}
		}
		if(Gdx.input.isKeyPressed(Keys.S)){
				if(mainpc.getY() > 0 && collisiondet.willcollide(mainpc.getX(), mainpc.getY()-2) == false)
				mainpc.translateY(-2f);

		}
		if(Gdx.input.isKeyPressed(Keys.S)&&Gdx.input.isKeyPressed(Keys.CONTROL_LEFT)){
			if(mainpc.getY() > 0 && collisiondet.willcollide(mainpc.getX(), mainpc.getY()-2) == false){
				mainpc.translateY(-2f);
			Healthbar.food -= .05;
		}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)){
				if(mainpc.getY() + 32 < 3616 && collisiondet.willcollide(mainpc.getX(), mainpc.getY()+2) == false)
				mainpc.translateY(2f);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)&&Gdx.input.isKeyPressed(Keys.CONTROL_LEFT)){
			if(mainpc.getY() + 32 < 3616 && collisiondet.willcollide(mainpc.getX(), mainpc.getY()+2) == false) {
				mainpc.translateY(2f);
				Healthbar.food -= .05;
			}
		}
		if(Gdx.input.isKeyPressed(Keys.TAB))
		{
			setScreen(new chooseblock(game));

		}

        if(Gdx.input.isKeyPressed(Keys.BACKSPACE)){


            changeblock.modify(mainpc.getX() + (Gdx.input.getX() - Gdx.graphics.getWidth() / 2), mainpc.getY() - (Gdx.input.getY() - Gdx.graphics.getHeight() / 2));


        }

		if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
            if ((System.currentTimeMillis()) > (timeSince + itemCoolDown)) {
                if (b.checkforitem(required) != -1) {
                    editing.editMap(mainpc.getX() + (Gdx.input.getX() - Gdx.graphics.getWidth() / 2), mainpc.getY() - (Gdx.input.getY() - Gdx.graphics.getHeight() / 2), blocktype);
                    b.tools[b.checkforitem(required)] = null;
                }
                timeSince = System.currentTimeMillis();
            }
        }

		if(Gdx.input.isKeyJustPressed(Keys.ENTER))
		{
			use.apply(currentitem);
		}
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
		{
			if((System.currentTimeMillis()) > (timeSince + itemCoolDown)) {
                GiveItem.gimme(mainpc.getX() + (Gdx.input.getX() - Gdx.graphics.getWidth() / 2), mainpc.getY() - (Gdx.input.getY() - Gdx.graphics.getHeight() / 2));
                timeSince = System.currentTimeMillis();
            }
		}

		if(Gdx.input.isKeyPressed(Keys.SHIFT_LEFT))
		{
			b.draw(tiledMapRenderer.getBatch());
			if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			    int ClickX = (int) ((Gdx.graphics.getWidth() - mainpc.getWidth())/2); //  This gives us the actual physical position of MAIN PC
                int CameraX = (int) mainpc.getX(); // Gives us the Camera postion
                int OffsetX = Math.abs(ClickX - CameraX);
                int ClickY = (int) ((Gdx.graphics.getHeight() - mainpc.getHeight())/2); //  This gives us the actual physical position of MAIN PC
                int CameraY = (int) mainpc.getY(); // Gives us the Camera postion
                int OffsetY = Math.abs(ClickY - CameraY);


                for(int i = 0; i < 36; i++)
				{

                    //System.out.println(" I : " + i + " :: "+ Gdx.input.getX() + " :OFFSET : " + OffsetX + " : hold : " + b.hold[i] + " :: " + (1080-Gdx.input.getY()) + " :OFFSET : " + OffsetY + " : hold : " + b.hold2[i]);
					if(((Gdx.input.getX() + OffsetX >= b.hold[i] && Gdx.input.getX() + OffsetX  <= (b.hold[i]+100)) && ((1080-Gdx.input.getY()) + OffsetY >= b.hold2[i] && (1080-Gdx.input.getY()) + OffsetY <= (b.hold2[i] + 100))))
					{

						b.reset();
						b.spots[i] = b.sel;
						currentitem = i;
						break;
					}
				}
			}
		}

		batch.setProjectionMatrix(camera.combined);
		mainpc.draw(tiledMapRenderer.getBatch());

		if(Healthbar.checkhealth() == true)
		{
			Gdx.app.exit();
		}

		tiledMapRenderer.getBatch().end();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		shape.setColor(1, 0, 0, 1);
		shape.rect(40, 1000, Healthbar.getHealth(), 10);
		shape.setColor(0, 1, 0, 1);
		shape.rect(150, 1000, Healthbar.getFood()/2, 10);
		shape.setColor(0, 0, 1, 1);
		shape.rect(260, 1000, Healthbar.getWater()/2, 10);
		shape.end();
	}


	@Override
	public void dispose () {
		batch.dispose();

	}

}
