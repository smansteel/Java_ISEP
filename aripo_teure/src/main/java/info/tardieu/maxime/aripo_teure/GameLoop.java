package info.tardieu.maxime.aripo_teure;

import info.tardieu.maxime.aripo_teure.ui.Cli;
import info.tardieu.maxime.aripo_teure.ui.Gui;
import info.tardieu.maxime.aripo_teure.ui.UserInteract;
import info.tardieu.maxime.aripo_teure.gameclasses.GameTurn;

public class GameLoop  {

    private String ioMethod;
    private UserInteract UserInterface;
    private int level;
    private int stage;
    private int storyId;
    private String language;
    private GameTurn turn;

    public String getLanguage() {
        return language;
    }

    public String getIoMethod() {
        return ioMethod;
    }

    public void setIoMethod(String ioMethod) {
        this.ioMethod = ioMethod;
    }

    public GameLoop(String ioMethod, String language) throws Exception {
        this.ioMethod = ioMethod;
        this.level = 0;
        this.stage = 0;
        this.language = language;
        if(this.ioMethod.equalsIgnoreCase("gui")){
            this.UserInterface = new Gui();
            UserInterface.start();
        }
        else {
            this.UserInterface = new Cli(language);
        }
    }

    public void start(){
        this.UserInterface.decorateXML(0); //Display message about game infos
        this.turn = new GameTurn();
        this.turn.start(this.language, this.UserInterface);
        this.play();

    }

    public void play() {

        storyId = 1;
        while(true){
           this.turn.next();
        }
    }

}
