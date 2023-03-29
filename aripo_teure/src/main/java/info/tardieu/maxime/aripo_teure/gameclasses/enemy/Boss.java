package info.tardieu.maxime.aripo_teure.gameclasses.enemy;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Bosses;
import info.tardieu.maxime.aripo_teure.gameclasses.spell.Spell;

public class Boss extends AbstractEnemy {
    private String name;
    private int healthPoints;
    private int manaa;
    private AbstractSpell[] spellsLearned;
    private AbstractSpell[] spellsWeak;
    private Bosses type;

    private int damage;

    public Boss(String name, Bosses type, int healthPoints, int manaa, AbstractSpell[] spellsLearned, AbstractSpell[] spellsWeak, int damage) {
        this.name = name;
        this.type = type;
        this.healthPoints = healthPoints;
        this.manaa = manaa;
        this.spellsLearned = spellsLearned;
        this.spellsWeak = spellsWeak;
        this.damage = damage;
    }

    @Override
    public void attack(Character target, Spell spell) {

    }
    public Bosses getType(){
        return this.type;
    }

}
