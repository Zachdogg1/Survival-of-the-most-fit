package inven2;

import com.mygdx.game.Healthbar;
import com.mygdx.game.MyGdxGame;
import static com.mygdx.game.MyGdxGame.b;
/**
 * Created by 256233 on 4/20/2017.
 */
public class use {

    public static void apply (int i)
    {
        BasicInven c = new BasicInven();
        c = MyGdxGame.getB();
        if(b.tools[i] != null)
        {

            Healthbar.restorehealth(b.tools[i].getHealthrestored());
            Healthbar.restorefood(b.tools[i].getFoodrestored());
            Healthbar.restorewater(b.tools[i].getWaterrestored());
        }
        b.tools[i] = null;
    }
}
