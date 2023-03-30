package info.tardieu.maxime.aripo_teure.gameclasses.enemy;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Bosses;
import info.tardieu.maxime.aripo_teure.gameclasses.spell.Spell;

public class Boss extends AbstractEnemy {



    private Bosses type;

    public Boss(String name, Bosses type, int healthPoints,int maxHealthPoints,  int manaa, AbstractSpell[] spellsLearned, AbstractSpell[] spellsWeak, int damage) {
        this.name = name;
        this.type = type;
        this.health = healthPoints;
        this.maxHealth = maxHealthPoints;
        this.manaa = manaa;
        this.spellsLearned = spellsLearned;
        this.spellsWeak = spellsWeak;
        this.damage = damage;
    }

    public Boss clone(){
        return new Boss(this.name, this.type, this.health, this.maxHealth, this.manaa, this.spellsLearned, this.spellsWeak, this.damage);
    }


    public Bosses getType(){
        return this.type;
    }

}
