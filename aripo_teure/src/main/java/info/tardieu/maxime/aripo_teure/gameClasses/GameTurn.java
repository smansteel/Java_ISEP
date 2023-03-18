package info.tardieu.maxime.aripo_teure.gameClasses;

public class GameTurn {
    private Character player;
    private Level[] levels;
    public void start(String language){
        this.player = new Wizard();
        this.levels = LevelInfo.getLevels(language);




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
