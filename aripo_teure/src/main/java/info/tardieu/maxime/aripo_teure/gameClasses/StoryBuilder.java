package info.tardieu.maxime.aripo_teure.gameClasses;

import info.tardieu.maxime.aripo_teure.StoryFetch;
import info.tardieu.maxime.aripo_teure.gameClasses.attributes.LevelType;
import info.tardieu.maxime.aripo_teure.gameClasses.attributes.Potion;
import info.tardieu.maxime.aripo_teure.gameClasses.attributes.Effect;
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
                       LevelType.BOSS_FIGHT
               ).fillBoss(
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
                       sf.getString(1), //lossString
                       new Object[]{}



               )
        };



        return story_array;
   };

   public static Hashtable<String, AbstractSpell> getSpells(String language){
       StoryFetch sf = new StoryFetch(language);
       Hashtable<String,AbstractSpell> hash_spells = new Hashtable<String,AbstractSpell>();

        String wingardiumLeviosa = sf.getString(2);
       String wingardiumLeviosaDescription = sf.getString(2);
        String wingardiumLeviosaEffect = sf.getString(2);
        hash_spells.put("wingardium", new Spell(
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
        StoryFetch sf = new StoryFetch(language);
        Hashtable<String,Potion> hash_potions = new Hashtable<String,Potion>();

        String healPotion = sf.getString(2);

        hash_potions.put("heal", new Potion(
                new Effect(),
                healPotion
        ));

        return hash_potions;

    }

}
