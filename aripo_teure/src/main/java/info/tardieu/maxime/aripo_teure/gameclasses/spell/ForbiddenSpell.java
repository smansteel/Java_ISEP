package info.tardieu.maxime.aripo_teure.gameclasses.spell;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Spells;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Effect;

public class ForbiddenSpell extends AbstractSpell {
    public ForbiddenSpell(Spells name, int hitProbability, int damageWeak, int damage, int damageRange, String name_str, String description, Effect effect, int effectProbability) {
        super(name, hitProbability, damageWeak, damage, damageRange, name_str, description, effect, effectProbability);
    }
}
