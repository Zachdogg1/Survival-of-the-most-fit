package inven2;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by 256233 on 4/13/2017.
 */
public class Starttiems {
    public Tool steak;
    public Tool waterbottle;
    public Tool knife;
    public Texture stek, wat;
    public void start(){
        stek = new Texture("data/steak.png");
        wat = new Texture("data/water.png");
        steak = new Tool();
        steak.setImage(stek);
        steak.setFoodrestored(50);
        steak.setHealthrestored(10);
        waterbottle = new Tool();
        waterbottle.setWaterrestored(30);
        waterbottle.setImage(wat);
        knife = new Tool();
        knife.setDamage(10);

    }
}
