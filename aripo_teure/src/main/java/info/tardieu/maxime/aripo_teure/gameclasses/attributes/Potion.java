package info.tardieu.maxime.aripo_teure.gameclasses.attributes;


import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Effects;

public class Potion {
    private Effects effect;
    private String name;

    public Potion(Effects effect, String name) {
        this.effect = effect;
        this.name = name;
    }

    public Effects getEffect() {
        return effect;
    }

    public String getName() {
        return name;
    }
}
