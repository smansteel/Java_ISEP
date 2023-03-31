package info.tardieu.maxime.aripo_teure.gameclasses.abstracts;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.HouseList;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;

public abstract class Character {
    protected String name ;
    protected int health ;
    protected int maxHealth;
    protected int manaa ;
    protected boolean isDefending;
    protected float damageReduction; //%
    protected int damage;

    protected int maxManna;
    public int attack(Character target, int damage){
        if (!target.isDefending()){
            int damages;

            if(target instanceof Wizard && ((Wizard) target).getHouse().getHouseIn()== HouseList.Gryffindor){


                damages = (int) ((damage)*(100-(target.getDamageReduction()*1.2))/100);
            }else{

                damages = (int) (  (damage)*(100-target.getDamageReduction())/100);
            }

            target.setHealth(target.getHealth() - damages) ;
            return  damages;
        }
        return 0;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public void defend(){
        this.isDefending = true;
    }

    public float getDamageReduction() {
        return damageReduction;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isDefending() {
        return isDefending;
    }

    public void setDefending(boolean defending) {
        damageReduction = damageReduction/2;
        isDefending = defending;
    }

    public boolean isAlive(){
        if(health>0){
            return true;
        }else{
            return false;
        }
    }


    public void kill(){
        health = 0;
    }

    public int getHealth(){
        return this.health;
    }
    public int getMaxHealth(){
        return this.maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
