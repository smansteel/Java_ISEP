package info.tardieu.maxime.aripo_teure.utils;

import info.tardieu.maxime.aripo_teure.gameclasses.wand.Core;

import java.util.Random;

public class RandomFromEnum<T extends Enum<T>>
{
    public T random(T inputEnum){
        for (inputEnum:enumerator
             ) {

        }
        T[] random = inputEnum.values();
        return random[new Random().nextInt(random.length)];
    }
}
