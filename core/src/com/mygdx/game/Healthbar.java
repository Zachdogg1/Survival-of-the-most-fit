package com.mygdx.game;

/**
 * Created by 256233 on 4/7/2017.
 */
public class Healthbar {
    static int counter;
   static int food, water, health;
    public static void reset()
    {
        counter = 0;
        food = 200;
        water = 200;
        health = 100;

    }
    public static void runeachtime()
    {
        counter++;
        if(counter % 90 == 0)
        {
            water--;
        }
        if(counter % 180 == 0)
        {
            food--;
        }
        if ( water <= 0 || food <= 0)
        {
            health --;
            if(water < 0) water = 0;

            if(food < 0) food = 0;
        }
        if(counter > 190)
        {
            counter = 0;
        }
    }
    public static boolean checkhealth()
    {
        if (health < 0)
        {
            return true;
        }
        return false;
    }
    public static int getHealth()
    {
        return health;
    }
    public static int getFood()
    {
        return food;
    }
    public static int getWater()
    {
        return water;
    }
}
