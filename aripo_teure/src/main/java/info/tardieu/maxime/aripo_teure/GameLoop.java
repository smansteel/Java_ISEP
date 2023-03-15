package info.tardieu.maxime.aripo_teure;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class GameLoop  {

    private String ioMethod;
    private UserInteract UserInterface;
    private int level;
    private int stage;
    private int storyId;
    private String language;

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
        this.UserInterface.displayMessage(System.getProperty("os.name"));
        this.UserInterface.displayStory(this.level, this.language);
        this.play();

    }



    public void play() {
        storyId = 1;
        while(true){
            for(int i = 0; i<= this.UserInterface.getMaxStoryid();i++)
            this.UserInterface.displayStory(this.storyId+i, this.language);


        }
    }

}
