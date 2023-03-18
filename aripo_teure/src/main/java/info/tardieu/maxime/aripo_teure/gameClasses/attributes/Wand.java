package info.tardieu.maxime.aripo_teure.gameClasses.attributes;

public class Wand {
    private String name;
    private int damageMultiplier; // in %, 100 is base
    private int damageMultiplierForbidden; // in %, 100 is base
    private Core core; // lightsaber crystal
    private int size; //in cm (even if size doesn't matter)

    public Wand(String name, int damageMultiplier,int damageMultiplierForbidden, Core core, int size) {
        this.name = name;
        this.damageMultiplier = damageMultiplier;
        this.damageMultiplierForbidden = damageMultiplierForbidden;
        this.core = core;
        this.size = size;
    }
}
