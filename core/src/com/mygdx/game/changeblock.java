package com.mygdx.game;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;

import static com.mygdx.game.MyGdxGame.map;


/**
 * Created by 256233 on 2/14/2017.
 */
public class changeblock{


    public static void modify (float posx, float posy)
    {

        int x = Math.round(posx/32);
        int y = Math.round(posy/32);
        if (x > 0 && y > 0 && x < 200 && y < 113) {
            ((TiledMapTileLayer) MyGdxGame.newmap.getLayers().get("Tile Layer 2")).setCell(x, y, null);
        }
    }
}
