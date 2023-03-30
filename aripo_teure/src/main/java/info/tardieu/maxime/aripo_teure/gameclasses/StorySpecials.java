package info.tardieu.maxime.aripo_teure.gameclasses;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.*;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Item;
import info.tardieu.maxime.aripo_teure.gameclasses.enemy.Boss;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;

import java.util.Objects;

public class StorySpecials {
    public static boolean checkBellatrixInteraction(Wizard player, Boss enemy){
        if ((player.getWandCore() == Core.PHOENIX_FEATHER) && (enemy.getType() == Bosses.BELLATRIX)){
            return true;

        }else{
            return false;
        }
    }

    public static boolean checkBook(Item item){

        return item.getEffect() == Effects.BOOK_DESTROYER;
    }

    public static boolean checkFireworks(Item item){
        return item.getEffect() == Effects.FIREWORKED;
    }


    public static boolean checkTrollInteraction( AbstractEnemy enemy, AbstractSpell attack){
        return (attack.getName() == Spells.WINGARDIUM_LEVIOSA) && (enemy.getType() == Bosses.TROLL);
    }
    public static boolean checkPettigrowInteraction( AbstractEnemy enemy, AbstractSpell attack){
        return (attack.getName() == Spells.ACCIO) && (enemy.getType() == Bosses.PETTIGROW);
    }

    public static boolean checkDementorInteraction(AbstractEnemy enemy, AbstractSpell attack){
        return (attack.getName() == Spells.EXPECTO_PATRONUM) && (enemy.getType() == Bosses.DEMENTOR);
    }

    public static boolean checkDeathEaterAlliance(Wizard player, AbstractEnemy enemy){
        return (player.getHouse().getHouseIn() == HouseList.Slytherin) && (enemy.getType() == Bosses.DEATHEATER);
    }

}
