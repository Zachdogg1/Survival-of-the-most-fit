package com.mygdx.game;

import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;



public class collisiondet {
    private static int objectlayer = 0;
    private static TiledMapTileLayer collision = (TiledMap) MyGdxGame.map.getLayers().get(objectlayer);
    private static MapObjects object = collision.getObjects();
    public static boolean willcollide(float posx, float posy)
    {
        for(RectangleMapObject rectacngleobject : object.getByType(RectangleMapObject.class))
        {
            Rectangle rectangle = rectacngleobject.getRectangle();
            Rectangle playercoll = new Rectangle(posx,posy,32,32);
            if(Intersector.overlaps(rectangle,playercoll))
            {
                return true;
            }

        }
        return false;
    }
}
