package com.mygdx.game;

import java.util.Random;

/**
 * Created by 256233 on 1/31/2017.
 */

public class randomgeneration {
   public static int characters ()
    {
        Random ch = new Random();
        int finished = ch.nextInt(3 );
        return finished;

    }
}
