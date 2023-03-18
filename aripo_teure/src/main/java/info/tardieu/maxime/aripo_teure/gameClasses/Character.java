package info.tardieu.maxime.aripo_teure.gameClasses;

import info.tardieu.maxime.aripo_teure.gameClasses.spell.Spell;

public abstract class Character {
    private String name ;
    private int health ;
    private int manaa ;
    public abstract void attack(Character target, Spell spell) ;





}
