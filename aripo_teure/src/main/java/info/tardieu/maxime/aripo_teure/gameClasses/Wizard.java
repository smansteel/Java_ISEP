package info.tardieu.maxime.aripo_teure.gameClasses;

import info.tardieu.maxime.aripo_teure.gameClasses.attributes.House;
import info.tardieu.maxime.aripo_teure.gameClasses.attributes.Pet;
import info.tardieu.maxime.aripo_teure.gameClasses.attributes.Potion;
import info.tardieu.maxime.aripo_teure.gameClasses.attributes.Wand;
import info.tardieu.maxime.aripo_teure.gameClasses.spell.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameClasses.spell.Spell;

import java.util.Hashtable;

public class Wizard extends Character{
    private Pet pet;
    private Wand wand;
    private House house;
    private Hashtable<String, AbstractSpell> knownSpells;
    private Hashtable<String, Potion> potions;



    @Override
    public void attack(Character target, Spell spell) {

    }
}
