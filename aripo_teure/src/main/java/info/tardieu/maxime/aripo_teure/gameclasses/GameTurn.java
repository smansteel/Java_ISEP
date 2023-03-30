package info.tardieu.maxime.aripo_teure.gameclasses;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Actions;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Potion;
import info.tardieu.maxime.aripo_teure.gameclasses.enemy.Boss;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;
import info.tardieu.maxime.aripo_teure.ui.UserInteract;
import info.tardieu.maxime.aripo_teure.gameclasses.storymanagement.Level;
import info.tardieu.maxime.aripo_teure.gameclasses.storymanagement.StoryBuilder;

import static info.tardieu.maxime.aripo_teure.gameclasses.StorySpecials.checkInteraction;

public class GameTurn {
    private Wizard player;
    private String language;
    private UserInteract userInterface;
    private int nextTile;
    private boolean lastRoundPlayed;
    private Level[] levels;
    public void start(String language, UserInteract userInterface){
        this.player = new Wizard();
        this.language = language;
        String name = userInterface.askName(this.language);
        String wandName = userInterface.askStringXML(13);
        this.player.setWandName(wandName);
        this.player.setName(name) ;
        this.levels = StoryBuilder.getLevels(language);
        //userInterface.displayMessage(name);
        this.userInterface = userInterface;
        this.userInterface.setPlayerName(name);
        nextTile =0;

        this.levels =  StoryBuilder.getLevels(this.language);




    }
    public void next(){
        userInterface.clrScrn();
        switch(this.levels[nextTile].getLevelType()) {
            case BOSS_FIGHT:
                userInterface.decorate(this.levels[nextTile].getStartString());


                bossFight(this.player,  this.levels[nextTile]);
                nextTile ++;

                break;
            case FIGHT:
                userInterface.displayMessage("w");
                userInterface.displayMessage(this.levels[nextTile].getStartString());
                nextTile ++;
                break;
            case DISCOVERY:
                userInterface.displayMessage(this.levels[nextTile].getStartString());
                for (Object object: this.levels[nextTile].getRoomContent()
                     ) {
                    if (object instanceof  AbstractSpell){
                        player.learn(( AbstractSpell )object);

                    } else if (object instanceof Potion) {
                        player.pickUp( ( Potion ) object);
                    }
                }

                userInterface.displayMessage(this.levels[nextTile].getEndString());
                userInterface.awaitEnter();
                nextTile ++;
                break;
        }




    }

    public void bossFight(Wizard player, Level level){
        AbstractEnemy lastenemy = level.getEnemies()[0];

        while(player.isAlive() && level.ennemiesAtLeastOneAlive()){
        boolean foundAction = false;

            Object action =  this.userInterface.askAction(player);
            if (action == null){
                lastRoundPlayed = false;
            }else{
                lastRoundPlayed = true;
            }


            if (lastRoundPlayed){
                if(action instanceof AbstractSpell){
                    AbstractSpell converted = (AbstractSpell) action;
                    //enemy.attack(player);
                    AbstractEnemy choice = this.userInterface.whichEnemy(level);
                    int damages = player.castSpell(converted, choice);
                    if (damages >=0 && choice.isAlive()){
                        this.userInterface.displayDamages(damages);

                    } else if (damages >=0 && !choice.isAlive()){
                        this.userInterface.displayEnemyDeath(choice);

                    } else if (damages == -2) {
                        if (!choice.isAlive()){
                            this.userInterface.displayEnemyDeath(choice);
                        }

                    }else if(damages == -1){
                        this.userInterface.displayFromXML(133);
                    }


                } else if (action instanceof Potion) {
                    Potion converted = (Potion) action;
                    AbstractEnemy choice = this.userInterface.whichEnemy(level);
                    int damages = player.usePotion(converted);
                    if (damages >=0 && choice.isAlive()){
                        this.userInterface.displayDamages(damages);

                    } else if (damages >=0 && !choice.isAlive()){
                        this.userInterface.displayEnemyDeath(choice);

                    } else if (damages == -2) {
                        if (!choice.isAlive()){
                            this.userInterface.displayEnemyDeath(choice);
                        }

                    }else if(damages == -1){
                        this.userInterface.displayFromXML(133);
                    }
                }


            }

        }
        if(!level.ennemiesAtLeastOneAlive()){
            this.userInterface.displayMessage(level.getWinString());
        }
        if(!player.isAlive()){
            this.userInterface.displayPlayerDeath(player, lastenemy);
        }

    }
    public void playerTurn(){

    }
    public void aiTurn(){

    }
    public void makeLevel(int level){

    }
}
