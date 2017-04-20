package inven2;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MyGdxGame;

/**
 * Created by 256233 on 4/11/2017.
 */
public class BasicInven {
    public int[] hold = new int[36];
    public int[] hold2 = new int[36];
    public Sprite[] spots = new Sprite[36];
    public Tool[] tools = new Tool[36];
    public Texture normal = new Texture("data/box.png");
    public Texture select = new Texture("data/selected.png");
    public Sprite sel = new Sprite(select);
    public Sprite nor = new Sprite(normal);
    public Starttiems starttiems = new Starttiems();
public void start()
{
    starttiems.start();
    tools[0] = starttiems.waterbottle;
    tools[1] = starttiems.steak;

    spots[0] = new Sprite(select);
    for(int i = 1; i < 36; i++)
    {
        spots[i] = new Sprite(normal);
    }
}
public void reset(){
    for(int i = 0; i < 36; i++)
    {
        spots[i] = nor;
    }
}
public void draw(Batch batch)
{
    for(int i = 0; i < 9; i++)
    {

        spots[i].setPosition(MyGdxGame.getCamera().position.x + 40 +   100*i,MyGdxGame.getCamera().position.y + 400);
        hold[i] = Math.round(MyGdxGame.getCamera().position.x + 40 +   100*i);
        hold2[i] = Math.round(MyGdxGame.getCamera().position.y + 400);
        if(tools[i] != null)
        {
            tools[i].getImage().setPosition(hold[i], hold2[i]);
            tools[i].getImage().draw(batch);
        }
        spots[i].draw(batch);
        spots[i+9].setPosition(MyGdxGame.getCamera().position.x + 40 + 100 * i, MyGdxGame.getCamera().position.y + 300);
        hold[i+9] = Math.round(MyGdxGame.getCamera().position.x + 40 + 100 * i);
        hold2[i+9] = Math.round(MyGdxGame.getCamera().position.y + 300);
        if(tools[i+9] != null)
        {
            tools[i+9].getImage().setPosition(hold[i+9], hold2[i+9]);
            tools[i +9].getImage().draw(batch);
        }
        spots[i+9].draw(batch);
        spots[i+18].setPosition(MyGdxGame.getCamera().position.x + 40 + 100 * i, MyGdxGame.getCamera().position.y +200);
        hold[i+18] = Math.round(MyGdxGame.getCamera().position.x + 40 + 100 * i);
        hold2[i+18] = Math.round(MyGdxGame.getCamera().position.y + 200);
        if(tools[i+18] != null)
        {
            tools[i +18].getImage().setPosition(hold[i + 18], hold2[i + 18]);
            tools[i +18].getImage().draw(batch);
        }
        spots[i+18].draw(batch);
        spots[i+27].setPosition(MyGdxGame.getCamera().position.x + 40 + 100 * i, MyGdxGame.getCamera().position.y +100);
        hold[i+27] = Math.round(MyGdxGame.getCamera().position.x + 40 + 100 * i);
        hold2[i+27] = Math.round(MyGdxGame.getCamera().position.y + 100);
        if(tools[i + 27] != null)
        {
            tools[i + 27].getImage().setPosition(hold[i + 27], hold2[i + 27]);
            tools[i +27].getImage().draw(batch);
        }
        spots[i+27].draw(batch);


    }

    /*
    for(int i = 9; i < 18; i++)
    {
        for(int k = 0; k < 9; k++) {
            spots[i].setPosition(MyGdxGame.getCamera().position.x + 40 + 100 * k, MyGdxGame.getCamera().position.y + 300);
            hold[i] = Math.round(MyGdxGame.getCamera().position.x + 40 + 100 * k);
            hold2[i] = Math.round(MyGdxGame.getCamera().position.y + 300);
            spots[i].draw(batch);
        }

    }
    for(int i = 18; i < 27; i++)
    {
        for(int k = 0; k < 9; k++) {
            spots[i].setPosition(MyGdxGame.getCamera().position.x + 40 + 100 * k, MyGdxGame.getCamera().position.y +200);
            hold[i] = Math.round(MyGdxGame.getCamera().position.x + 40 + 100 * k);
            hold2[i] = Math.round(MyGdxGame.getCamera().position.y + 200);
            spots[i].draw(batch);
        }

    }
    for(int i = 27; i < 36; i++)
    {
        for(int k = 0; k < 9; k++) {
            spots[i].setPosition(MyGdxGame.getCamera().position.x + 40 + 100 * k, MyGdxGame.getCamera().position.y +100);
            hold[i] = Math.round(MyGdxGame.getCamera().position.x + 40 + 100 * k);
            hold2[i] = Math.round(MyGdxGame.getCamera().position.y + 100);
            spots[i].draw(batch);
        }

    }
    */

}
}
