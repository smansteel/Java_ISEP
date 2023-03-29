package info.tardieu.maxime.aripo_teure.gameclasses.storymanagement;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Bosses;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.LevelType;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Spells;
import info.tardieu.maxime.aripo_teure.iomanagement.StrFetch;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Potion;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Effect;
import info.tardieu.maxime.aripo_teure.gameclasses.enemy.Boss;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.spell.Spell;

import java.util.Hashtable;

public class StoryBuilder {


   public static Level[] getLevels(String language) {
       StrFetch sf = new StrFetch(language);
       Hashtable<String,AbstractSpell> spells = getSpells(language);


       Level[] story_array = {
               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{
                               new Boss(sf.getString(7),
                                       Bosses.TROLL,
                                       100,
                                       10,
                                       new AbstractSpell[]{
                                               spells.get("papte")
                                       },
                                       new AbstractSpell[]{
                                               spells.get("wingardium")
                                       },
                                       5)},
                       sf.getString(8), //startString
                       sf.getString(9), //winString
                       sf.getString(10), //lossString
                       new Object[]{}



               )
        };



        return story_array;
   };

   public static Hashtable<String, AbstractSpell> getSpells(String language){
       StrFetch sf = new StrFetch(language);
       Hashtable<String,AbstractSpell> hash_spells = new Hashtable<String,AbstractSpell>();

        String wingardiumLeviosa = sf.getString(3);
       String wingardiumLeviosaDescription = sf.getString(4);
        String wingardiumLeviosaEffect = sf.getString(5);
        hash_spells.put("wingardium", new Spell(
                Spells.WINGARDIUM_LEVIOSA,
                20,
                100,
                20,
                0,
                wingardiumLeviosa,
                wingardiumLeviosaDescription,
                new Effect(),
                90
        ));

       return hash_spells;

   }

    public static Hashtable<String, Potion> getPotions(String language){
        StrFetch sf = new StrFetch(language);
        Hashtable<String,Potion> hash_potions = new Hashtable<String,Potion>();

        String healPotion = sf.getString(6);

        hash_potions.put("heal", new Potion(
                new Effect(),
                healPotion
        ));

        return hash_potions;

    }

}
