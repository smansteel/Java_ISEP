package info.tardieu.maxime.aripo_teure.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Random {
    public static int random(int lowerBound, int upperBound){
        return ThreadLocalRandom.current().nextInt(lowerBound, upperBound + 1);
    }
}
