package info.tardieu.maxime.aripo_teure.gameclasses.storymanagement;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Bosses;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Effects;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.LevelType;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Spells;
import info.tardieu.maxime.aripo_teure.gameclasses.spell.ForbiddenSpell;
import info.tardieu.maxime.aripo_teure.iomanagement.StrFetch;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Item;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Effect;
import info.tardieu.maxime.aripo_teure.gameclasses.enemy.Boss;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.spell.Spell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Objects;

public class StoryBuilder {
    private static Hashtable<String, Boss> getBosses( StrFetch sf, Hashtable<String,AbstractSpell> spells, Hashtable<String, Item> items){
        Hashtable<String, Boss> hash_boss = new Hashtable<String, Boss>();

        hash_boss.put("dementor", new Boss(sf.getString(38),
                Bosses.DEMENTOR,
                200,
                200,
                10,
                new AbstractSpell[]{ //knownspells

                },
                (new ArrayList<>(spells.values())).toArray(new AbstractSpell[0]), 20));


        hash_boss.put("pettigrow", new Boss(sf.getString(82),
                Bosses.PETTIGROW,
                400,
                400,
                10,
                new AbstractSpell[]{ //knownspells
                        spells.get("crucio")

                },
                (new ArrayList<>(spells.values())).toArray(new AbstractSpell[0]),
                15));


        hash_boss.put("umbridge", new Boss(sf.getString(81),
                Bosses.UMBRIDGE,
                400,
                400,
                10,
                new AbstractSpell[]{ //knownspells
                        spells.get("sectum"), spells.get("crucio"), spells.get("imperio")
                },
                (new ArrayList<>(spells.values())).toArray(new AbstractSpell[0]),
                30));


        hash_boss.put("deatheater", new Boss(sf.getString(83),
                Bosses.DEATHEATER,
                500,
                500,
                10,
                new AbstractSpell[]{ //knownspells
                        spells.get("sectum")
                },
                (new ArrayList<>(spells.values())).toArray(new AbstractSpell[0]),
                12));

        hash_boss.put("troll", new Boss(sf.getString(110),
                Bosses.TROLL,
                100,
                100,
                10,
                new AbstractSpell[]{
                        spells.get("crucio")
                },
                (new ArrayList<>(spells.values())).toArray(new AbstractSpell[0]),
                10));


        hash_boss.put("basilisk", new Boss(sf.getString(50),
                Bosses.BASILISK,
                200,
                200,
                10,
                new AbstractSpell[]{ //knownspells
                        spells.get("crucio")
                },
                (new ArrayList<>(spells.values())).toArray(new AbstractSpell[0]),
                15));

        hash_boss.put("bellatrix", new Boss(sf.getString(84),
                Bosses.BELLATRIX,
                1500,
                1500,
                10,
                new AbstractSpell[]{ //knownspells
                        spells.get("sectum"), spells.get("avada")
                },
                (new ArrayList<>(spells.values())).toArray(new AbstractSpell[0]),
                50));
        hash_boss.put("voldemort_weak", new Boss(sf.getString(86),
                Bosses.VOLDEMORT,
                400,
                400,
                10,
                new AbstractSpell[]{ //knownspells
                        spells.get("sectum")
                },
                (new ArrayList<>(spells.values())).toArray(new AbstractSpell[0]),
                20));
        hash_boss.put("voldemort", new Boss(sf.getString(86),
                Bosses.VOLDEMORT,
                1500,
                1500,
                10,
                new AbstractSpell[]{ //knownspells
                        spells.get("avada"), spells.get("sectum")
                },
                (new ArrayList<>(spells.values())).toArray(new AbstractSpell[0]),
                50));




        return hash_boss;
    }



    public static Level[] getLevels(String language) {
       StrFetch sf = new StrFetch(language);
       Hashtable<String,AbstractSpell> spells = getSpells(language);
       Hashtable<String, Item> items = getItems(language);
        Hashtable<String, Boss> bosses = getBosses(sf, spells, items);





       Object[] firstRoomObjects ;
       if((System.getenv("env")!= null && System.getenv("env").equals("DEBUG"))){
           firstRoomObjects = new Object[]{spells.get("wingardium"),
                   spells.get("protego"),
                   spells.get("debug"),
                   spells.get("crucio")};
       }       else{
           firstRoomObjects = new Object[]{spells.get("wingardium"),
                   spells.get("protego"),
                   spells.get("crucio")};
       }

       Level[] story_array = {

               new Level(
                       LevelType.DISCOVERY
               ).fillDisco(

                       sf.getString(60), //startString
                       sf.getString(61), //endString

                       firstRoomObjects


               ),
               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{
                               bosses.get("troll").clone()
                                      },
                       sf.getString(111), //startString
                       sf.getString(112), //winString
                       sf.getString(113), //lossString
                       new Object[]{}


               ),
                //If gryffindor, take sword
               new Level(
                       LevelType.DISCOVERY
               ).fillDisco(

                       sf.getString(71), //startString
                       sf.getString(72), //endString
                       new Object[]{items.get("sword"), items.get("heal"), spells.get("impero")}

               ),
                // 2nd level Chambre des secretscrucio
               // Basilic
               // Épée de Griffondor pour les Griffondor ; Croc du basilic avec Accio pour les autres

               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{
                               bosses.get("basilisk").clone()},
                       sf.getString(62), //startString
                       sf.getString(63), //winString
                       sf.getString(64), //lossString
                       new Object[]{items.get("fang")}

               ),
               new Level(
                       LevelType.DISCOVERY
               ).fillDisco(

                       sf.getString(71), //startString
                       sf.getString(72), //endString
                       new Object[]{spells.get("expecto")}

               ),

               //3rd level   Lac dans la Forêt Interdite
               // Détraqueurs
               // Utilisez votre Patronus ( Expecto Patronum) pour mettre les Détraqueurs en fuite !
               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{bosses.get("dementor").clone(), bosses.get("dementor").clone(),bosses.get("dementor").clone()
                       },
                       sf.getString(65), //startString
                       sf.getString(66), //winString
                       sf.getString(67), //lossString
                       new Object[]{}

               ),

               new Level(
                       LevelType.DISCOVERY
               ).fillDisco(

                       sf.getString(73), //startString
                       sf.getString(74), //endString
                       new Object[]{spells.get("accio"), items.get("heal")}

               ),

               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{bosses.get("pettigrow").clone(), bosses.get("voldemort_weak").clone()
                       },
                       sf.getString(68), //startString
                       sf.getString(69), //winString
                       sf.getString(70), //lossString
                       new Object[]{}

               ),
               new Level(
                       LevelType.DISCOVERY
               ).fillDisco(

                       sf.getString(160), //startString
                       sf.getString(161), //endString
                       new Object[]{spells.get("sectum")}

               ),

               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{bosses.get("umbridge").clone()
                       },
                       sf.getString(71), //startString
                       sf.getString(72), //winString
                       sf.getString(73), //lossString
                       new Object[]{items.get("fireworks")}

               ),
               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{bosses.get("deatheater").clone()
                       },
                       sf.getString(75), //startString
                       sf.getString(76), //winString
                       sf.getString(77), //lossString
                       new Object[]{}

               ),
               new Level(
                       LevelType.DISCOVERY
               ).fillDisco(

                       sf.getString(162), //startString
                       sf.getString(163), //endString
                       new Object[]{items.get("avada")}

               ),
               new Level(
                       LevelType.BOSS_FIGHT
               ).fillBoss(
                       new Character[]{},
                       new Boss[]{bosses.get("bellatrix").clone(), bosses.get("voldemort").clone()
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
                75,
                100,
                20,
                0,
                wingardiumLeviosa,
                wingardiumLeviosaDescription,
                new Effect(Effects.WINGARDIUM_LEVIOSA),
                90
        ));


       String expectoPatronum = sf.getString(92);
       String expectoPatronumDescription = sf.getString(93);
       hash_spells.put("expecto", new Spell(
               Spells.EXPECTO_PATRONUM,
               90,
               0,
               0,
               0,
               expectoPatronum,
               expectoPatronumDescription,
               new Effect(Effects.EXPECTO_PATRONUM),
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
               50,
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
               175,
               50,
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
               200,
               50,
               0,
               imperio,
               imperioDesc,
               null,
               75
       ));

       String crucio = sf.getString(102);
       String crucioDesc = sf.getString(103);
       hash_spells.put("crucio", new ForbiddenSpell(
               Spells.CRUCIO,
               65,
               50,
               15,
               50,
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
               0,
               protego,
               protegoDesc,
               new Effect(Effects.PROTECT),
               75
       ));

       String debug = "debug";
       hash_spells.put("debug", new Spell(
               Spells.DEBUG,
               100,
               200000,
               20000,
               0,
               debug,
               "debug",
               new Effect(),
               100
       ));


       return hash_spells;

   }

    public static Hashtable<String, Item> getItems(String language){
        StrFetch sf = new StrFetch(language);
        Hashtable<String, Item> hash_potions = new Hashtable<String, Item>();

        String healPotion = sf.getString(40);

        hash_potions.put("heal", new Item(
                Effects.HEAL,
                healPotion,
                5

        ));
        String fireworksName = sf.getString(41);
        hash_potions.put("fireworks", new Item(
                Effects.FIREWORKED,
                fireworksName
        ));
        String basiliskFangName = sf.getString(42);
        hash_potions.put("fang", new Item(
                Effects.BOOK_DESTROYER,
                basiliskFangName
        ));
        String gryffyndorSwordName = sf.getString(43);
        hash_potions.put("sword", new Item(
                Effects.BOOK_DESTROYER,
                gryffyndorSwordName
        ));


        return hash_potions;

    }

}
