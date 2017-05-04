package buttons;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mygdx.game.MyGdxGame;
import inven2.Starttiems;

import static com.mygdx.game.MyGdxGame.b;

/**
 * Created by 256233 on 4/3/2017.
 */
public class Button3 extends Actor {
    private Texture texture;
    private Sprite sprite;
    private Starttiems c;
    public Button3(){
        c = new Starttiems();
        texture = new Texture("data/tiles/3.png");
        sprite = new Sprite(texture);
        sprite.setPosition(270,90);
        setBounds(this.sprite.getX(), this.sprite.getY(), this.sprite.getWidth(), this.sprite.getHeight());
        setTouchable(Touchable.enabled);
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (button == Input.Buttons.LEFT) {
                    MyGdxGame.changetype(2);
                    MyGdxGame.setRequired(b.starttiems.wood);
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
