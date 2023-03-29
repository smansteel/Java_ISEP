package info.tardieu.maxime.aripo_teure.gameclasses.attributes;



public class Potion {
    private Effect effect;
    private String name;

    public Potion(Effect effect, String name) {
        this.effect = effect;
        this.name = name;
    }

    public Effect getEffect() {
        return effect;
    }

    public String getName() {
        return name;
    }
}
