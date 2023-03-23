package info.tardieu.maxime.aripo_teure.gameclasses;

import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;
import info.tardieu.maxime.aripo_teure.ui.UserInteract;
import info.tardieu.maxime.aripo_teure.gameclasses.storymanagement.Level;
import info.tardieu.maxime.aripo_teure.gameclasses.storymanagement.StoryBuilder;

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
                break;
            case FIGHT:
                userInterface.displayMessage("w");
                userInterface.displayMessage(this.levels[nextTile].getStartString());
                break;
        }




    }

    public void fight(){

    }
    public void playerTurn(){

    }
    public void aiTurn(){

    }
    public void makeLevel(int level){

    }
}
