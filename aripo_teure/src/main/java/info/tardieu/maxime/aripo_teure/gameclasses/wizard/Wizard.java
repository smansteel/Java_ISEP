package info.tardieu.maxime.aripo_teure.gameclasses.wizard;

import info.tardieu.maxime.aripo_teure.gameclasses.StorySpecials;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.*;
import info.tardieu.maxime.aripo_teure.gameclasses.houses.House;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Item;
import info.tardieu.maxime.aripo_teure.gameclasses.wand.Wand;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;


import java.util.Hashtable;

import static info.tardieu.maxime.aripo_teure.utils.Random.random;


public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private Hashtable<String, AbstractSpell> knownSpells;
    private Hashtable<String, Item> potions;


    public Wizard( ) {
        if(System.getenv("env")!= null && System.getenv("env").equals("DEBUG")){
            maxHealth = 100000000;
            health = 100000000;
        }else{
            maxHealth = 100;
            health = 100;
        }

        this.damage = 5;
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
            return 0;
        }else{
            int spellDamages;
            if (enemy.getSpellsWeakAsList().contains(spell)){
                spellDamages = spell.getDamageWeak();
            }else{
                spellDamages = spell.getDamage();
            }
            int getHitProb;
            if (this.getHouse().getHouseIn()== HouseList.Ravenclaw){
                getHitProb = (int) (spell.getHitProbability()*1.2);
            }else{
                getHitProb = (spell.getHitProbability());
            }
            if( random100() <= getHitProb){
                int randomDamages = randomRange100((int)((float)spell.getDamageRange()) * spellDamages/100);
                int ttDamages;
                if (this.getHouse().getHouseIn()== HouseList.Slytherin){
                    ttDamages = (int) ((spellDamages* randomDamages/100)*1.2);
                }else{
                    ttDamages =((spellDamages* randomDamages/100));
                }
                return this.attack(enemy, ttDamages);
            }else{

                return -1;
            }
        }



    }

    public int usePotion(Item item){
        if(item.getEffect()== Effects.HEAL){

            int heal;
            if (this.getHouse().getHouseIn()== HouseList.Hufflepuff){
                heal = 50;
            }else{
                heal = 30;
            }
            if (this.health +heal>this.maxHealth){
                health = maxHealth;
            }else{
                this.health = this.health +heal;
            }


            item.use();
        }
        return 0;
    }

    public void learn(AbstractSpell spell){
        this.knownSpells.put(spell.getNameStr(), spell);
    }
    public void pickUp(Item item){
        this.potions.put(item.getName(), item);
    }
}
