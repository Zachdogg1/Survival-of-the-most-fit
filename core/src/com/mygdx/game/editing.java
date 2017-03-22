package com.mygdx.game;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import static com.mygdx.game.MyGdxGame.map;

/**
 * Created by 256233 on 3/16/2017.
 */
public class editing {
    private static TiledMapTileLayer collision = (TiledMapTileLayer) map.getLayers().get("layer1");
    private static TiledMapTileLayer.Cell myCell;

    public static void editMap(float posx, float posy, int blocktype) {

        int x = Math.round(posx / 32);
        int y = Math.round(posy / 32);
        if (x > 0 && y > 0 && x < 200 && y < 113) {
            TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) MyGdxGame.map.getLayers().get(0)).getCell(blocktype, 0);
            ((TiledMapTileLayer) MyGdxGame.newmap.getLayers().get("Tile Layer 2")).setCell(x, y, cell);

            myCell = collision.getCell(x, y);
            Object test = myCell.getTile().getProperties().get("stop");
            if (test != null) {
                TiledMapTileLayer.Cell cell2 = ((TiledMapTileLayer) MyGdxGame.map.getLayers().get(0)).getCell(1, 1);
                ((TiledMapTileLayer) MyGdxGame.newmap.getLayers().get("layer1")).setCell(x, y, cell2);
            }

        }
    }
}
