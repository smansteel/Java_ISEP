package info.tardieu.maxime.aripo_teure.gameclasses.abstracts;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Spells;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Effect;

public abstract class AbstractSpell {
    private int hitProbability; // 0-100%
    private int damageWeak; //damages dealt when the opponent is weak
    private int damage; //damages dealt
    private int damageRange; //% of the damage that should be random
    private String name_str; // its name
    private String description; // its description
    private Effect effect; // its effect
    private int effectProbability;
    private Spells name;

    public AbstractSpell(Spells name,int hitProbability, int damageWeak, int damage, int damageRange, String name_str, String description, Effect effect, int effectProbability) {
        this.name = name;
        this.hitProbability = hitProbability;
        this.damageWeak = damageWeak;
        this.damage = damage;
        this.damageRange = damageRange;
        this.name_str = name_str;
        this.description = description;
        this.effect = effect;
        this.effectProbability = effectProbability;
    }

    public int getHitProbability() {
        return hitProbability;
    }

    public int getDamageWeak() {
        return damageWeak;
    }

    public int getDamage() {
        return damage;
    }

    public int getDamageRange() {
        return damageRange;
    }

    public String getDescription() {
        return description;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getEffectProbability() {
        return effectProbability;
    }

    public String getNameStr(){
        return this.name_str;
    }
}
