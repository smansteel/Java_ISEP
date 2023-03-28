package info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums;

import java.util.Random;

public enum Woods {
    ACACIA, ALDER, APPLE, ASH, ASPEN, BEECH, BLACKTHORN, BLACK_WALNUT, CEDAR, CHERRY, CHESTNUT, CYPRESS, DOGWOOD, EBONY, ELDER, ELM, ENGLISH_OAK, FIR, HAWTHORN, HAZEL, HOLLY, HORNBEAM, LARCH, LAUREL, MAPLE, PEAR, PINE, POPLAR, RED_OAK, REDWOOD, ROWAN, SILVER_LIME, SPRUCE, SYCAMORE, VINE, WALNUT, WILLOW, YEW;
    public static Woods randomWood()  {
        Woods[] random = values();
        return random[new Random().nextInt(random.length)];
    }
}
