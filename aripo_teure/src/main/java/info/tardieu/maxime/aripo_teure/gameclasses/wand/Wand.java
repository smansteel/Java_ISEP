package info.tardieu.maxime.aripo_teure.gameclasses.wand;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Core;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Woods;

import java.util.Random;

public class Wand {
    private String name;
    private int damageMultiplier; // in %, 100 is base
    private int damageMultiplierForbidden; // in %, 100 is base
    private Core core; // lightsaber crystal
    private int size; //in cm (even if size doesn't matter)
    private Woods wood;

    public Wand(String name) {
        this.name = name;
        this.damageMultiplier = new Random().nextInt(50+1) +75;
        this.damageMultiplierForbidden = new Random().nextInt(50+1) +75;
        this.core = Core.randomCore();
        this.size = new Random().nextInt(19+1) +10;
        this.wood = Woods.randomWood();
    }
    public Core getCore(){
        return this.core;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Woods getWood() {
        return wood;
    }

    public void setName(String name) {
        this.name = name;
    }
}
