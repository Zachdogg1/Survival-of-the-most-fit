package inven2;

import com.mygdx.game.Healthbar;
import com.mygdx.game.MyGdxGame;

/**
 * Created by 256233 on 4/20/2017.
 */
public class use {

    public static void apply (int i)
    {
        BasicInven c = new BasicInven();
        c = MyGdxGame.getB();
        if(c.tools[i] != null)
        {

            Healthbar.restorehealth(c.tools[i].getFoodrestored());
            Healthbar.restorefood(c.tools[i].getFoodrestored());
            Healthbar.restorewater(c.tools[i].getWaterrestored());
        }
    }
}
