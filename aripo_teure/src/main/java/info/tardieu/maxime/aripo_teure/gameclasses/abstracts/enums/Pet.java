package info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums;

import java.util.Random;

public enum Pet {
    OWL,
    RAT,
    CAT,
    TOAD;
    public static Pet randomPet()  {
        Pet[] random = values();
        return random[new Random().nextInt(random.length)];
    }
}
