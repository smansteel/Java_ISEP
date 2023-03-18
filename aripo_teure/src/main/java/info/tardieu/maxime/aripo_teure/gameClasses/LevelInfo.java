package info.tardieu.maxime.aripo_teure.gameClasses;

import info.tardieu.maxime.aripo_teure.GameLoop;
import info.tardieu.maxime.aripo_teure.StoryFetch;
import info.tardieu.maxime.aripo_teure.gameClasses.enemy.Boss;
import info.tardieu.maxime.aripo_teure.gameClasses.enemy.Enemy;
import info.tardieu.maxime.aripo_teure.gameClasses.spell.Spell;

import java.util.Hashtable;

public class LevelInfo {


   public static Level[] getLevels(String language) {
       StoryFetch sf = new StoryFetch(language);
       Hashtable<String,Spell> spells = getSpells(language);


       Level[] story_array = {
               new Level(
                       new Character[]{},
                       new Boss[]{
                               new Boss(sf.getString(1),
                                       100,
                                       10,
                                       new Spell[]{
                                               spells.get("papte")
                                       },
                                       new Spell[]{
                                               spells.get("papte")
                                       },
                                       5)},
                       sf.getString(1), //startString
                       sf.getString(1), //winString
                       sf.getString(1) //lossString

               )

        };



        return story_array;
   };

   public static Hashtable<String,Spell> getSpells(String language){
       StoryFetch sf = new StoryFetch(language);
       Hashtable<String,Spell> hash_spells = new Hashtable<String,Spell>();

        String wingardiumLeviosa = sf.getString(2);
        hash_spells.put(wingardiumLeviosa, new Spell());



       return hash_spells;

   }

}
