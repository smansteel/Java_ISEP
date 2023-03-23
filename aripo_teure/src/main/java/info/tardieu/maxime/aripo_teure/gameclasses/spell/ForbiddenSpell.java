package info.tardieu.maxime.aripo_teure.gameclasses.spell;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Effect;

public class ForbiddenSpell extends AbstractSpell {
    private int hitProbability; // 0-100%
    private int damageWeak; //damages dealt when the opponent is weak
    private int damage; //damages dealt
    private int damageRange; //% of the damage that should be random
    private String name; // its name
    private String description; // its description
    private Effect effect; // its effect
    private int effectProbability;
}
