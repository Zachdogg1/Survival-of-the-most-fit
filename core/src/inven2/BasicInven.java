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

    public Sprite[] spots = new Sprite[36];
    public Tool[] tools = new Tool[36];
public void start()
{
    Texture normal = new Texture("data/box.png");
    Texture select = new Texture("data/selected.png");

    spots[0] = new Sprite(select);
    for(int i = 1; i < 36; i++)
    {
        spots[i] = new Sprite(normal);
    }
}

public void draw(Batch batch)
{
    for(int i = 0; i < 9; i++)
    {

        spots[i].setPosition(MyGdxGame.getCamera().position.x + 40 +   100*i,MyGdxGame.getCamera().position.y + 400);
        spots[i].draw(batch);
    }
    for(int i = 9; i < 18; i++)
    {
        for(int k = 0; k < 9; k++) {
            spots[i].setPosition(MyGdxGame.getCamera().position.x + 40 + 100 * k, MyGdxGame.getCamera().position.y + 300);
            spots[i].draw(batch);
        }

    }
    for(int i = 18; i < 27; i++)
    {
        for(int k = 0; k < 9; k++) {
            spots[i].setPosition(MyGdxGame.getCamera().position.x + 40 + 100 * k, MyGdxGame.getCamera().position.y +200);

            spots[i].draw(batch);
        }

    }
    for(int i = 27; i < 36; i++)
    {
        for(int k = 0; k < 9; k++) {
            spots[i].setPosition(MyGdxGame.getCamera().position.x + 40 + 100 * k, MyGdxGame.getCamera().position.y +100);
            spots[i].draw(batch);
        }

    }
}
}
