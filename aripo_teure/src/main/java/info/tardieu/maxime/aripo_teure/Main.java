package info.tardieu.maxime.aripo_teure;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void startGame(String ioMethod) throws Exception {
        String language = System.getenv("LANG");
        GameLoop game = new GameLoop(ioMethod, language);
        game.start();
    }

    public static void main(String[] args) throws Exception {

        if(args[0].equalsIgnoreCase("cli")){
            startGame("cli");
        }else if(args[0].equalsIgnoreCase("gui")){
            startGame("gui");
        }
        else{
            System.out.println("Start cli or gui ? [CLI/gui]");
            Scanner scan = new Scanner(System.in);
            if (scan.nextLine().equalsIgnoreCase("gui")){
                startGame("gui");

            }else{
                startGame("cli");
            }

        }
    }
}