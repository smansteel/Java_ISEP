package info.tardieu.maxime.aripo_teure.gameclasses.wizard;

import info.tardieu.maxime.aripo_teure.gameclasses.StorySpecials;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.houses.House;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Pet;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Potion;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Core;
import info.tardieu.maxime.aripo_teure.gameclasses.wand.Wand;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.spell.Spell;


import java.util.Hashtable;

import static info.tardieu.maxime.aripo_teure.utils.Random.random;


public class Wizard extends Character {
    private Pet pet;
    private Wand wand;
    private House house;
    private String name;
    private Hashtable<String, AbstractSpell> knownSpells;
    private Hashtable<String, Potion> potions;



    @Override
    public void attack(Character target, Spell spell) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hashtable<String, AbstractSpell> getKnownSpells() {
        return knownSpells;
    }

    public Hashtable<String, Potion> getPotions() {
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

    public void castSpell(AbstractSpell spell, AbstractEnemy enemy){
        if( random100() > spell.getHitProbability()){
            int randomDamages = randomRange100(spell.getDamageRange()/100 * spell.getDamage());
            enemy.takeDamage(spell.getDamage()* randomDamages);
        }else{
            if (StorySpecials.checkTrollInteraction(this, enemy, spell)){
                enemy.kill();
            }
        }


    }

    public void usePotion(Potion potion){

    }
}
