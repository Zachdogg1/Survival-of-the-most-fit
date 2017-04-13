package inven2;

/**
 * Created by 256233 on 4/13/2017.
 */
public class Starttiems {
    public Tool steak;
    public Tool waterbottle;
    public Tool knife;
    public void start(){
        steak = new Tool();
        steak.setFoodrestored(50);
        steak.setHealthrestored(10);
        waterbottle = new Tool();
        waterbottle.setWaterrestored(50);
        knife = new Tool();
        knife.setDamage(10);

    }
}
