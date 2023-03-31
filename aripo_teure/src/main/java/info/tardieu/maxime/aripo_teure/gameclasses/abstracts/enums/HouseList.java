package info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums;

import java.util.Random;

public enum HouseList {
    Gryffindor,
    Ravenclaw,
    Hufflepuff,
    Slytherin;

    public static HouseList sortingHat()  {
        HouseList[] random = values();
        return random[new Random().nextInt(random.length)];
    }

}
