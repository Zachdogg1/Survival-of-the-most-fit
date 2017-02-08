package com.mygdx.game;

import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;

// Class for detecting collsion

public class collisiondet {

    private static int objectlayer = 0;
    private static TiledMapTileLayer collision = (TiledMapTileLayer) MyGdxGame.map.getLayers().get(objectlayer);
    private static MapObjects object = collision.getObjects();
    private static TiledMapTileLayer.Cell cell;
    public static boolean willcollide(float posx, float posy)
    {

                int x = Math.round(posx);
                int y = Math.round(posy);
                 cell = collision.getCell(x/32, y/32);
                TiledMapTile tile = cell.getTile();
                MapProperties test = tile.getProperties();
                if(test.containsKey("stop"))
                {
                    return true;
                }




        return false;
    }
}
