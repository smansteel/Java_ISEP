package info.tardieu.maxime.aripo_teure.gameclasses.abstracts;

import info.tardieu.maxime.aripo_teure.gameclasses.spell.Spell;

public abstract class Character {
    private String name ;
    private int health ;
    private int manaa ;
    public abstract void attack(Character target, Spell spell) ;

    public boolean isAlive(){
        if(health<0){
            return false;
        }else{
            return true;
        }
    }

    public void takeDamage(int damage){
        health = health - damage;
    }
    public void kill(){
        health = 0;
    }





}
