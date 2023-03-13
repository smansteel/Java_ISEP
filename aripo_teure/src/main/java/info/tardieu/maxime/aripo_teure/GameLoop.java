package info.tardieu.maxime.aripo_teure;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class GameLoop  {

    private String ioMethod;
    private UserInteract UserInterface;
    private int level;
    private int stage;

    public String getIoMethod() {
        return ioMethod;
    }

    public void setIoMethod(String ioMethod) {
        this.ioMethod = ioMethod;
    }

    public GameLoop(String ioMethod) throws Exception {
        this.ioMethod = ioMethod;
        this.level = 0;
        this.stage = 0;
        if(this.ioMethod.equalsIgnoreCase("gui")){
            this.UserInterface = new Gui();
            UserInterface.start();
        }
        else {
            this.UserInterface = new Cli();
        }
    }

    public void start(){
        this.UserInterface.displayMessage(System.getProperty("os.name"));

    }

    public void play() throws ParserConfigurationException, IOException, SAXException {
        while(true){
            StoryFetch doggo = new StoryFetch();
            doggo.getLevelStage(this.level, this.stage);
        }
    }

}
