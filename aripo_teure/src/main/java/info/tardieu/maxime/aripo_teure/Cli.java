package info.tardieu.maxime.aripo_teure;


import java.io.IOException;

public class Cli implements UserInteract{
    public void terminalClear(){
        //Does not work, on w10 at least
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else{
                //Runtime.getRuntime().exec("clear");
                System.out.println("test not wondows");
                }
        } catch (IOException | InterruptedException ex) {}
    }

    @Override
    public void displayStory(int level, int stage){


    }
    @Override
    public void displayMessage(String message){
        System.out.println(message);

    }

}
