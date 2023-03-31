package info.tardieu.maxime.aripo_teure.gameclasses.attributes;


import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Effects;

public class Item {
    private Effects effect;
    private String name;
    private int number;

    public Item(Effects effect, String name) {
        this.effect = effect;
        this.name = name;
    }
    public Item(Effects effect, String name, int number) {
        this.effect = effect;
        this.name = name;
        this.number = number;
    }

    public void use(){
        this.number = this.number-1;
    }
    public Effects getEffect() {
        return effect;
    }

    public String getName() {
        return name;
    }
}
