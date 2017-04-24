package com.mygdx.game;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inven2.BasicInven;
import inven2.Starttiems;

import static com.badlogic.gdx.utils.JsonValue.ValueType.object;
import static com.mygdx.game.MyGdxGame.map;
import static com.mygdx.game.MyGdxGame.newmap;
import static com.mygdx.game.MyGdxGame.b;
/**
 * Created by 256233 on 4/24/2017.
 */
public class GiveItem {

    private static TiledMapTileLayer riv = (TiledMapTileLayer) newmap.getLayers().get("river");
    private static TiledMapTileLayer.Cell river;
    private static TiledMapTileLayer top = (TiledMapTileLayer) newmap.getLayers().get("Tile Layer 2");
    private static TiledMapTileLayer.Cell cellomine;
    private static Starttiems a = new Starttiems();
    public static void gimme(float posx, float posy)
    {
        int x = Math.round(posx/32);
        int y = Math.round(posy/32);

        river = riv.getCell(x, y);
        cellomine = top.getCell(x,y);
        Object check1 = river.getTile().getProperties().get("givewater");
        Object check2 = cellomine.getTile().getProperties().get("Givefruit");
        if(check1 != null)
        {
            System.out.println("water");
            int next = b.nextfree();
            if(next != 36)
            b.tools[next] = b.starttiems.waterbottle;
        }
        if(check2 != null)
        {
            int next = b.nextfree();
            if(next != 36)
            b.tools[next] = b.starttiems.fruit;
            System.out.println("fruit");
        }

    }

}