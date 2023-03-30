package info.tardieu.maxime.aripo_teure.gameclasses;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.HouseList;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Potion;
import info.tardieu.maxime.aripo_teure.gameclasses.enemy.Boss;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Bosses;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Core;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;

import java.util.Objects;

public class StorySpecials {
    public static boolean checkInteraction(Wizard player, Boss enemy, AbstractSpell attack){
        if ((player.getWandCore() == Core.PHOENIX_FEATHER) && (enemy.getType() == Bosses.VOLDEMORT)){
            return true;

        }else{
            return false;
        }
    }

    public static boolean checkSword(Potion sword){
     return Objects.equals(sword.getName(), "sword") ;
    }

    public static boolean checkSpellInteraction(Wizard player, Boss enemy, AbstractSpell attack){
        if ((attack.getNameStr().equalsIgnoreCase("wingardium")) && (enemy.getType() == Bosses.TROLL)){
            return true;

        } else if ((enemy.getType() == Bosses.DEATHEATER)&& (attack.getNameStr().equalsIgnoreCase("Sectumsempra"))) {
            return true;

        }else if ((enemy.getType() == Bosses.VOLDEMORT)&& (attack.getNameStr().equalsIgnoreCase("expelliarmus"))) {
            return true;}
            else{
            return false;

        }
    }

    public static boolean checkTrollInteraction(Wizard player, AbstractEnemy enemy, AbstractSpell attack){
        if ((attack.getNameStr().equalsIgnoreCase("wingardium")) && (enemy.getType() == Bosses.TROLL)){
            return true;}
        else {
            return false;

        }
    }
}
