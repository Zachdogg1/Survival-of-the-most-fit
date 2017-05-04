package com.mygdx.game;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;

import static com.badlogic.gdx.utils.JsonValue.ValueType.object;
import static com.mygdx.game.MyGdxGame.map;
import static com.mygdx.game.MyGdxGame.b;


/**
 * Created by 256233 on 2/14/2017.
 */
public class changeblock{

    private static TiledMapTileLayer collision = (TiledMapTileLayer) map.getLayers().get("layer1");
    private static TiledMapTileLayer.Cell myCell;
    private static TiledMapTileLayer riv = (TiledMapTileLayer) map.getLayers().get("river");
    private static TiledMapTileLayer.Cell river, justonce;
    private static TiledMapTileLayer ontop = (TiledMapTileLayer) map.getLayers().get("Tile Layer 2");
    public static void modify (float posx, float posy)
    {

        int x = Math.round(posx/32);
        int y = Math.round(posy/32);
        justonce = ontop.getCell(x,y);
        myCell = collision.getCell(x, y);
        river = riv.getCell(x, y);
        Object dont = river.getTile().getProperties().get("dont");
        Object check = justonce.getTile().getProperties().get("Givewood");

        if(check != null)
        {
            int next = b.nextfree();
            if(next != 36)
            b.tools[next] = b.starttiems.wood;
        }
        if (x > 0 && y > 0 && x < 200 && y < 113) {
            TiledMapTileLayer.Cell cell2 = ((TiledMapTileLayer) MyGdxGame.map.getLayers().get(0)).getCell(2, 1);
            ((TiledMapTileLayer) MyGdxGame.newmap.getLayers().get("Tile Layer 2")).setCell(x, y, cell2);
        }
        if(dont != null)
        {
            TiledMapTileLayer.Cell cell2 = ((TiledMapTileLayer) MyGdxGame.map.getLayers().get(0)).getCell(0, 1);
            ((TiledMapTileLayer) MyGdxGame.newmap.getLayers().get("layer1")).setCell(x, y, cell2);
        }
        else{
            TiledMapTileLayer.Cell cell2 = ((TiledMapTileLayer) MyGdxGame.map.getLayers().get(0)).getCell(1, 1);
            ((TiledMapTileLayer) MyGdxGame.newmap.getLayers().get("layer1")).setCell(x, y, cell2);
        }
    }
}
