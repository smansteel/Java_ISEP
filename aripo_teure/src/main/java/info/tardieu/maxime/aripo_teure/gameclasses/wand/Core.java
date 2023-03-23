package info.tardieu.maxime.aripo_teure.gameclasses.wand;

import java.util.Random;

public enum Core {
    PHOENIX_FEATHER,
    DRAGON_HEARTSTRING,
    UNICORN_HAIR;

    public static Core randomCore()  {
        Core[] random = values();
        return random[new Random().nextInt(random.length)];
    }
}
