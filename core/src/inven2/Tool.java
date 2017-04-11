package inven2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by 256233 on 4/11/2017.
 */
public class Tool {
    static int foodrestored;
    static int waterrestored;
    static  int healthrestored;
    static  Texture texture;
    static Sprite image;

    static int damage;
    public static int getFoodrestored()
    {
        return foodrestored;
    }
    public static int getWaterrestored()
    {
        return waterrestored;
    }
    public static int getHealthrestored()
    {
        return healthrestored;
    }
    public static int getDamage()
    {
        return damage;
    }
    public static Sprite getImage()
    {
        return image;
    }

}
