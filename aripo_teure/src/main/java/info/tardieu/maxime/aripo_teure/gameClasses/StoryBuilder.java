package info.tardieu.maxime.aripo_teure.gameClasses;

import info.tardieu.maxime.aripo_teure.StoryFetch;
import info.tardieu.maxime.aripo_teure.gameClasses.attributes.SpellEffect;
import info.tardieu.maxime.aripo_teure.gameClasses.enemy.Boss;
import info.tardieu.maxime.aripo_teure.gameClasses.spell.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameClasses.spell.Spell;

import java.util.Hashtable;

public class StoryBuilder {


   public static Level[] getLevels(String language) {
       StoryFetch sf = new StoryFetch(language);
       Hashtable<String,AbstractSpell> spells = getSpells(language);


       Level[] story_array = {
               new Level(
                       new Character[]{},
                       new Boss[]{
                               new Boss(sf.getString(1),
                                       100,
                                       10,
                                       new AbstractSpell[]{
                                               spells.get("papte")
                                       },
                                       new AbstractSpell[]{
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

   public static Hashtable<String, AbstractSpell> getSpells(String language){
       StoryFetch sf = new StoryFetch(language);
       Hashtable<String,AbstractSpell> hash_spells = new Hashtable<String,AbstractSpell>();

        String wingardiumLeviosa = sf.getString(2);
        String wingardiumLeviosaEffect = sf.getString(2);
        hash_spells.put(wingardiumLeviosa, new Spell(
                20,
                100,
                20,
                0,
                wingardiumLeviosa,
                new SpellEffect(),
                90
        ));



       return hash_spells;

   }

}
