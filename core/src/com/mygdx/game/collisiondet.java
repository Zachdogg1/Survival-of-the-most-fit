package com.mygdx.game;

import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;

import static com.mygdx.game.MyGdxGame.map;

// Class for detecting collsion

public class collisiondet {

    private static int objectlayer = 0;
    private static TiledMapTileLayer collision = (TiledMapTileLayer) map.getLayers().get("layer1");
    private static TiledMapTileLayer.Cell myCell;
    public static boolean willcollide(float posx, float posy)
    {

                int x = Math.round(posx/32);
                int y = Math.round(posy/32);
                System.out.println(x + ", " + y);
                System.out.println(collision.getHeight() + ", " + collision.getWidth());
                myCell = collision.getCell(x, y);
                System.out.println(myCell.getTile().getId());
                Object test = myCell.getTile().getProperties().get("stop");
                if(test != null)
                {
                    return true;
                }




        return false;
    }
}
