package info.tardieu.maxime.aripo_teure.gameclasses.storymanagement;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Bosses;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Effects;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.LevelType;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Spells;
import info.tardieu.maxime.aripo_teure.gameclasses.spell.ForbiddenSpell;
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
       Hashtable<String,Potion> potions = getPotions(language);

       Boss dementor = new Boss(sf.getString(50),
               Bosses.DEMENTOR,
               200,
               200,
               10,
               new AbstractSpell[]{ //knownspells
                       spells.get("papte")
               },
               new AbstractSpell[]{ //spells weak to
                       spells.get("expecto")
               },
               5);


       Boss pettigrow = new Boss(sf.getString(90),
               Bosses.PETTIGROW,
               400,
               400,
               10,
               new AbstractSpell[]{ //knownspells

               },
               new AbstractSpell[]{ //spells weak to
                       spells.get("expecto")
               },
               5);


       Boss umbridge = new Boss(sf.getString(91),
               Bosses.UMBRIDGE,
               400,
               400,
               10,
               new AbstractSpell[]{ //knownspells
                    spells.get("sectum"), spells.get("protego")
               },
               new AbstractSpell[]{ //spells weak to

               },
               5);

       Boss deatheater = new Boss(sf.getString(92),
               Bosses.DEATHEATER,
               500,
               500,
               10,
               new AbstractSpell[]{ //knownspells
                       spells.get("sectum")
               },
               new AbstractSpell[]{ //spells weak to

               },
               50);

       Boss bellatrix = new Boss(sf.getString(92),
               Bosses.BELLATRIX,
               1500,
               1500,
               10,
               new AbstractSpell[]{ //knownspells
                       spells.get("sectum")
               },
               new AbstractSpell[]{ //spells weak to

               },
               50);


       Level[] story_array = {

               new Level(
                       LevelType.DISCOVERY
               ).fillDisco(

                       sf.getString(60), //startString
                       sf.getString(61), //endString
                       new Object[]{spells.get("wingardium"), spells.get("protego"), spells.get("imperio")}


               ),
               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{
                               new Boss(sf.getString(110),
                                       Bosses.TROLL,
                                       100,
                                       100,
                                       10,
                                       new AbstractSpell[]{

                                       },
                                       new AbstractSpell[]{

                                       },
                                       20)},
                       sf.getString(111), //startString
                       sf.getString(112), //winString
                       sf.getString(113), //lossString
                       new Object[]{}




               ),
                //If gryffindor, take sword
               new Level(
                       LevelType.DISCOVERY
               ).fillDisco(

                       sf.getString(62), //startString
                       sf.getString(63), //endString
                       new Object[]{potions.get("sword")}

               ),
                // 2nd level Chambre des secrets
               // Basilic
               // Épée de Griffondor pour les Griffondor ; Croc du basilic avec Accio pour les autres

               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{
                               new Boss(sf.getString(50),
                                       Bosses.BASILISK,
                                       200,
                                       200,
                                       10,
                                       new AbstractSpell[]{ //knownspells

                                       },
                                       new AbstractSpell[]{ //spells weak to

                                       },
                                       30)},
                       sf.getString(62), //startString
                       sf.getString(63), //winString
                       sf.getString(64), //lossString
                       new Object[]{potions.get("fang")}

               ),

               //3rd level   Lac dans la Forêt Interdite
               // Détraqueurs
               // Utilisez votre Patronus ( Expecto Patronum) pour mettre les Détraqueurs en fuite !
               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{dementor, dementor, dementor
                       },
                       sf.getString(65), //startString
                       sf.getString(66), //winString
                       sf.getString(67), //lossString
                       new Object[]{}

               ),

               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{pettigrow
                       },
                       sf.getString(68), //startString
                       sf.getString(69), //winString
                       sf.getString(70), //lossString
                       new Object[]{}

               ),
               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{umbridge
                       },
                       sf.getString(71), //startString
                       sf.getString(72), //winString
                       sf.getString(73), //lossString
                       new Object[]{potions.get("fireworks")}

               ),
               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{deatheater
                       },
                       sf.getString(75), //startString
                       sf.getString(76), //winString
                       sf.getString(77), //lossString
                       new Object[]{}

               ),
               new Level(
                       LevelType.DISCOVERY
               ).fillDisco(

                       sf.getString(60), //startString
                       sf.getString(61), //endString
                       new Object[]{potions.get("sword")}

               ),
               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{bellatrix
                       },
                       sf.getString(78), //startString
                       sf.getString(79), //winString
                       sf.getString(80), //lossString
                       new Object[]{}

               ),




        };



        return story_array;
   };

   public static Hashtable<String, AbstractSpell> getSpells(String language){
       StrFetch sf = new StrFetch(language);
       Hashtable<String,AbstractSpell> hash_spells = new Hashtable<String,AbstractSpell>();

        String wingardiumLeviosa = sf.getString(90);
       String wingardiumLeviosaDescription = sf.getString(91);

        hash_spells.put("wingardium", new Spell(
                Spells.WINGARDIUM_LEVIOSA,
                20,
                100,
                20,
                0,
                wingardiumLeviosa,
                wingardiumLeviosaDescription,
                null,
                90
        ));


       String expectoPatronum = sf.getString(92);
       String expectoPatronumDescription = sf.getString(93);
       hash_spells.put("expecto", new Spell(
               Spells.EXPECTO_PATRONUM,
               90,
               200,
               5,
               0,
               expectoPatronum,
               expectoPatronumDescription,
               new Effect(Effects.CONFUSED),
               90
       ));

       String accio = sf.getString(94);
       String accioDesc = sf.getString(95);
       hash_spells.put("accio", new Spell(
               Spells.ACCIO,
               95,
               200,
               0,
               0,
               accio,
               accioDesc,
               null,
               90
       ));

       String sectum = sf.getString(96);
       String sectumDesc = sf.getString(97);
       hash_spells.put("sectum", new Spell(
               Spells.SECTUMSEMPRA,
               75,
               200,
               100,
               25,
               sectum,
               sectumDesc,
               null,
               75
       ));

       String avada = sf.getString(98);
       String avadaDesc = sf.getString(99);
       hash_spells.put("avada", new ForbiddenSpell(
               Spells.AVADA_KEDAVRA,
               90,
               600,
               600,
               150,
               avada,
               avadaDesc,
               null,
               75
       ));
       String imperio = sf.getString(100);
       String imperioDesc = sf.getString(101);
       hash_spells.put("imperio", new ForbiddenSpell(
               Spells.IMPERIO,
               75,
               400,
               400,
               75,
               imperio,
               imperioDesc,
               null,
               75
       ));

       String crucio = sf.getString(102);
       String crucioDesc = sf.getString(103);
       hash_spells.put("imperio", new ForbiddenSpell(
               Spells.CRUCIO,
               50,
               200,
               200,
               25,
               crucio,
               crucioDesc,
               null,
               75
       ));

       String protego = sf.getString(104);
       String protegoDesc = sf.getString(105);
       hash_spells.put("protego", new Spell(
               Spells.PROTEGO,
               100,
               0,
               0,
               150,
               protego,
               protegoDesc,
               new Effect(Effects.PROTECT),
               75
       ));



       return hash_spells;

   }

    public static Hashtable<String, Potion> getPotions(String language){
        StrFetch sf = new StrFetch(language);
        Hashtable<String,Potion> hash_potions = new Hashtable<String,Potion>();

        String healPotion = sf.getString(40);

        hash_potions.put("heal", new Potion(
                Effects.HEAL,
                healPotion
        ));
        String fireworksName = sf.getString(41);
        hash_potions.put("Fireworks", new Potion(
                Effects.FIREWORKED,
                fireworksName
        ));
        String basiliskFangName = sf.getString(42);
        hash_potions.put("fang", new Potion(
                Effects.BOOK_DESTROYER,
                basiliskFangName
        ));
        String gryffyndorSwordName = sf.getString(43);
        hash_potions.put("sword", new Potion(
                Effects.BOOK_DESTROYER,
                gryffyndorSwordName
        ));


        return hash_potions;

    }

}
