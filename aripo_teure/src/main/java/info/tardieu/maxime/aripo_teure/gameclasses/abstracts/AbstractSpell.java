package info.tardieu.maxime.aripo_teure.gameclasses.abstracts;

import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Effect;

public abstract class AbstractSpell {
    private int hitProbability; // 0-100%
    private int damageWeak; //damages dealt when the opponent is weak
    private int damage; //damages dealt
    private int damageRange; //% of the damage that should be random
    private String name; // its name
    private String description; // its description
    private Effect effect; // its effect
    private int effectProbability;

    public AbstractSpell(int hitProbability, int damageWeak, int damage, int damageRange, String name, String description, Effect effect, int effectProbability) {
        this.hitProbability = hitProbability;
        this.damageWeak = damageWeak;
        this.damage = damage;
        this.damageRange = damageRange;
        this.name = name;
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

    public String getName(){
        return this.name;
    }
}
