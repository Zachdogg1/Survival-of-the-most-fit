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
    public Tool vegtable;
    public Texture stek, wat, fru, veg;
    public void start(){
        stek = new Texture("data/steak.png");
        wat = new Texture("data/water.png");
        fru = new Texture("data/mang.png");
        veg = new Texture("data/vege.png");
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
        vegtable = new Tool();
        vegtable.setFoodrestored(40);
        vegtable.setWaterrestored(-20);
        vegtable.setHealthrestored(20);
        vegtable.setImage(veg);
        knife = new Tool();
        knife.setDamage(10);

    }
}
