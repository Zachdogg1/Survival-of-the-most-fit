package com.mygdx.game;
import java.util.Random;
/**
 * Created by 256233 on 1/19/2017.
 */
public class Mapgeneration {
    public static int randInt(int min, int max) {


        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    public static int[][] tilemaker()
    {
        int[][] tempmatrix = new int[22][12];
        for(int i = 0; i < 22; i++)
        {
            for(int j = 0; j < 12; j++)
            {
                tempmatrix[i][j] = randInt(1,3);
            }
        }
        return tempmatrix;
    }
}
