package info.tardieu.maxime.aripo_teure.gameclasses.wizard;

import info.tardieu.maxime.aripo_teure.gameclasses.StorySpecials;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Spells;
import info.tardieu.maxime.aripo_teure.gameclasses.houses.House;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Pet;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Item;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Core;
import info.tardieu.maxime.aripo_teure.gameclasses.wand.Wand;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;


import java.util.Hashtable;

import static info.tardieu.maxime.aripo_teure.utils.Random.random;


public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private String name;
    private Hashtable<String, AbstractSpell> knownSpells;
    private Hashtable<String, Item> potions;


    public Wizard( ) {
        maxHealth = 100;
        health = 100;
        this.pet = Pet.randomPet();
        this.wand = new Wand("");
        this.house = new House();
        this.name = name;
        this.knownSpells = new Hashtable<String, AbstractSpell>();
        this.potions =  new Hashtable<String, Item>();
    }
    public void setWandName(String wandName){
        wand.setName(wandName);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public Wand getWand() {
        return wand;
    }

    public House getHouse() {
        return house;
    }

    public Hashtable<String, AbstractSpell> getKnownSpells() {
        return knownSpells;
    }

    public Hashtable<String, Item> getPotions() {
        return potions;
    }
    public Core getWandCore(){
        return this.wand.getCore();
    }
    private static int random100(){
        return random(0,100);
    }

    private static int randomRange100(int randomRange){
        return random(100 - randomRange,100 + randomRange);
    }

    public int castSpell(AbstractSpell spell, AbstractEnemy enemy){
        if(spell.getName() == Spells.PROTEGO){

        }
        if( random100() > spell.getHitProbability()){
            int randomDamages = randomRange100(spell.getDamageRange()/100 * spell.getDamage());
            this.attack(enemy, spell.getDamage()* randomDamages);
            return spell.getDamage()* randomDamages;
        }else{
            if (StorySpecials.checkTrollInteraction(this, enemy, spell)){
                enemy.kill();
                return -2;
            }
            return -1;
        }


    }

    public int usePotion(Item item){
        return 0;
    }

    public void learn(AbstractSpell spell){
        this.knownSpells.put(spell.getNameStr(), spell);
    }
    public void pickUp(Item item){
        this.potions.put(item.getName(), item);
    }
}
