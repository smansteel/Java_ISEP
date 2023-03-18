package info.tardieu.maxime.aripo_teure.gameClasses;

import info.tardieu.maxime.aripo_teure.UserInteract;

public class GameTurn {
    private Character player;
    private UserInteract userInterface;
    private Level[] levels;
    public void start(String language, UserInteract userInterface){
        this.player = new Wizard();
        this.levels = StoryBuilder.getLevels(language);
        this.userInterface = userInterface;




    }
    public void next(){

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
