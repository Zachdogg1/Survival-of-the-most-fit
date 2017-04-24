package inven2;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by 256233 on 4/13/2017.
 */
public class Starttiems {
    public Tool steak;
    public Tool waterbottle;
    public Tool knife;
    public Tool fruit;
    public Texture stek, wat, fru;
    public void start(){
        stek = new Texture("data/steak.png");
        wat = new Texture("data/water.png");
        fru = new Texture("data/mang.png");
        steak = new Tool();
        steak.setImage(stek);
        steak.setFoodrestored(50);
        steak.setHealthrestored(10);
        steak.setWaterrestored(-5);
        waterbottle = new Tool();
        waterbottle.setWaterrestored(30);
        waterbottle.setImage(wat);
        fruit = new Tool();
        fruit.setWaterrestored(5);
        fruit.setFoodrestored(25);
        fruit.setImage(fru);
        fruit.setHealthrestored(10);
        knife = new Tool();
        knife.setDamage(10);

    }
}
