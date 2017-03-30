package buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.MyGdxGame;

/**
 * Created by 256233 on 3/30/2017.
 */
public class Button1 extends Actor {
    private Texture texture;
    private Sprite sprite;
    public Button1(){

        texture = new Texture("data/tiles/1.png");
        sprite = new Sprite(texture);
        sprite.setPosition(90,90);
        setBounds(this.sprite.getX(), this.sprite.getY(), this.sprite.getWidth(), this.sprite.getHeight());
        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (button == Input.Buttons.LEFT) {
                    MyGdxGame.changetype(0);
                }
                return true;
            }
        });

    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
