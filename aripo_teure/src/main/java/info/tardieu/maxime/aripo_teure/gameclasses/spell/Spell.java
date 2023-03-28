package info.tardieu.maxime.aripo_teure.gameclasses.spell;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Effect;

public class Spell extends AbstractSpell {

    private int hitProbability; // 0-100%
    private int damageWeak; //damages dealt when the opponent is weak, and hitprob when opponnent is weak is always 100%
    private int damage; //damages dealt
    private int damageRange; //% of the damage that should be random
    private String name; // its name
    private String description; // its description
    private Effect effect; // its effect
    private int effectProbability;


    public Spell(int hitProbability, int damageWeak, int damage, int damageRange, String name, String description, Effect effect, int effectProbability) {
        super(hitProbability, damageWeak, damage, damageRange, name, description, effect, effectProbability);
    }

}
