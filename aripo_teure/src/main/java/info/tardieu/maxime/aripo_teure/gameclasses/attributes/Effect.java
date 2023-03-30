package info.tardieu.maxime.aripo_teure.gameclasses.attributes;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Effects;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;

public class Effect {
    private Effects effect;

    public Effect() {
        this.effect = null;
    }
    public Effect(Effects effect) {
        this.effect = effect;
    }

    public void applyEffect(Wizard player, AbstractEnemy enemy, Character[] target)
    {
        /*if (this.effect == )
        if (target.length==1){}*/

    }
    public Effects getEffect(){
        return effect;
    }
}
