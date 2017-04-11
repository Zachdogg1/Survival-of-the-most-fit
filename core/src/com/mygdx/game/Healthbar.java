package com.mygdx.game;

/**
 * Created by 256233 on 4/7/2017.
 */
public class Healthbar {
    Long counter;
    Short food, water, health;
    public Void runeachtime()
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
    }
}
