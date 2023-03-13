package info.tardieu.maxime.aripo_teure;
import java.util.Scanner;

public class Main {

    public static void startGame(String ioMethod){
        GameLoop game = new GameLoop(ioMethod);
        game.start();
    }

    public static void main(String[] args) {

        if(args[0].equalsIgnoreCase("cli")){

            System.out.println("Cli started");
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
                System.out.println("Starting cli");
                startGame("cli");


            }

        }
    }
}