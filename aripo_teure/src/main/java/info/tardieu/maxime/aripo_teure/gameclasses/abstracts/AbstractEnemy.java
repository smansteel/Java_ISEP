package info.tardieu.maxime.aripo_teure.gameclasses.abstracts;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Bosses;

public abstract class AbstractEnemy extends Character {
    protected AbstractSpell[] spellsLearned;
    protected AbstractSpell[] spellsWeak;
    protected int damage;

    public Bosses getType(){
        return null;
    }

    public AbstractEnemy(){
        super();

    }

    public String getName() {
        return name;
    }

}
