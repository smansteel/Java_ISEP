package info.tardieu.maxime.aripo_teure.gameclasses.abstracts;

public abstract class Character {
    protected String name ;
    protected int health ;
    protected int maxHealth;
    protected int manaa ;
    protected int maxManna;
    public void attack(Character target, int damage){
        target.health = target.health - damage;

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





}
