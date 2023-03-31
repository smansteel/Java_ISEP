package info.tardieu.maxime.aripo_teure.gameclasses.abstracts;

public abstract class Character {
    protected String name ;
    protected int health ;
    protected int maxHealth;
    protected int manaa ;
    protected boolean isDefending;
    protected float damageReduction; //%
    protected int maxManna;
    public boolean attack(Character target, int damage){
        if (!target.isDefending()){
            target.setHealth((int) (target.getHealth() - (damage)*(100-damageReduction)/100)) ;
            return true;
        }
        return false;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public void defend(){
        this.isDefending = true;
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





}
