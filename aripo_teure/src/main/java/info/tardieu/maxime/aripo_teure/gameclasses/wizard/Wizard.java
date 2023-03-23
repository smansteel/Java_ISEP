package info.tardieu.maxime.aripo_teure.gameclasses.wizard;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.houses.House;
import info.tardieu.maxime.aripo_teure.gameclasses.pet.Pet;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Potion;
import info.tardieu.maxime.aripo_teure.gameclasses.wand.Wand;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.spell.Spell;

import java.util.Hashtable;

public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private String name;
    private Hashtable<String, AbstractSpell> knownSpells;
    private Hashtable<String, Potion> potions;



    @Override
    public void attack(Character target, Spell spell) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
