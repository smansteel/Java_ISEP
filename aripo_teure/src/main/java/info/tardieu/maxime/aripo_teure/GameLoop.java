package info.tardieu.maxime.aripo_teure;

public class GameLoop  {

    private String ioMethod;
    private UserInteract UserInterface;

    public String getIoMethod() {
        return ioMethod;
    }

    public void setIoMethod(String ioMethod) {
        this.ioMethod = ioMethod;
    }

    public GameLoop(String ioMethod) {
        this.ioMethod = ioMethod;
        if(this.ioMethod.equalsIgnoreCase("gui")){
            this.UserInterface = new Gui();
        }
        else {
            this.UserInterface = new Cli();
        }
    }

    public void start(){
        this.UserInterface.displayMessage(System.getProperty("os.name"));

    }
}
