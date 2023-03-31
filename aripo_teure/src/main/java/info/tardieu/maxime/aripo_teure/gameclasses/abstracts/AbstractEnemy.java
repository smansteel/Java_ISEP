package info.tardieu.maxime.aripo_teure.gameclasses.abstracts;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Bosses;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;
import java.util.Random;

import static info.tardieu.maxime.aripo_teure.utils.Random.random;

public abstract class AbstractEnemy extends Character {
    protected AbstractSpell[] spellsLearned;
    protected AbstractSpell[] spellsWeak;


    public Bosses getType(){
        return null;
    }

    public AbstractEnemy(){

        super();
        damageReduction = 0;

    }

    public String getName() {
        return name;
    }

    public int autoAttack(Wizard player){
        Random rd = new Random();
        if (rd.nextBoolean() && spellsLearned.length >1){
            AbstractSpell spell = spellsLearned[random(0, spellsLearned.length)];
            int damages = spell.getDamage() + (random(0, spell.getDamageRange())*spell.getDamage()/100);
                return attack(player, damages);
        }
        else{
            return attack(player, damage);
        }



    }

}
