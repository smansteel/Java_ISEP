package info.tardieu.maxime.aripo_teure.gameClasses.enemy;

import info.tardieu.maxime.aripo_teure.gameClasses.Character;
import info.tardieu.maxime.aripo_teure.gameClasses.spell.Spell;

public class Boss extends Character {
    private String name;
    private int healthPoints;
    private int manaa;
    private Spell[] spellsLearned;
    private Spell[] spellsWeak;

    private int damage;

    public Boss(String name, int healthPoints, int manaa, Spell[] spellsLearned, Spell[] spellsWeak, int damage) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.manaa = manaa;
        this.spellsLearned = spellsLearned;
        this.spellsWeak = spellsWeak;
        this.damage = damage;
    }

    @Override
    public void attack(Character target, Spell spell) {

    }
}
