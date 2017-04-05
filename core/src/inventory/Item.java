package inventory;

/**
 * Created by 256233 on 2/23/2017.
 */
public class Item {

    private int blocknumber;
    private Item(int blocknumber) {
        this.blocknumber = blocknumber;
    }

    private String textureRegion;

    private Item(String textureRegion) {
        this.textureRegion = textureRegion;
    }

    public String getTextureRegion() {
        return textureRegion;
    }

}

