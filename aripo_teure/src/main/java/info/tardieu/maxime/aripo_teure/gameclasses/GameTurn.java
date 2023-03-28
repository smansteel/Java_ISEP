package info.tardieu.maxime.aripo_teure.gameclasses;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Actions;
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
    private Level[] levels;
    public void start(String language, UserInteract userInterface){
        this.player = new Wizard();
        this.language = language;
        String name = userInterface.askName(this.language);
        this.player.setName(name) ;
        this.levels = StoryBuilder.getLevels(language);
        userInterface.displayMessage(name);
        this.userInterface = userInterface;
        nextTile =0;

        this.levels =  StoryBuilder.getLevels(this.language);




    }
    public void next(){
        switch(this.levels[nextTile].getLevelType()) {
            case BOSS_FIGHT:
                    userInterface.displayMessage(this.levels[nextTile].getStartString());
                bossFight(this.player, (Boss) this.levels[nextTile].getEnemies()[0]);

                break;
            case FIGHT:
                userInterface.displayMessage("w");
                userInterface.displayMessage(this.levels[nextTile].getStartString());
                break;
        }




    }

    public void bossFight(Wizard player, Boss enemy){
        while(player.isAlive() && enemy.isAlive()){
        boolean foundAction = false;

            Actions action =  this.userInterface.askAction();


        switch (action) {
            case SPELL -> player.castSpell(this.userInterface.askSpell(), enemy);
            case POTION -> player.usePotion(this.userInterface.askPotion());
        }
        userInterface.displayMessage("chcoie" + action);

        //this.userInterface.askSpell();
        //checkInteraction(player, enemy, );
        }

    }
    public void playerTurn(){

    }
    public void aiTurn(){

    }
    public void makeLevel(int level){

    }
}
