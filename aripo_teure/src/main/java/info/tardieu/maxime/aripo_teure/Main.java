package info.tardieu.maxime.aripo_teure;
import info.tardieu.maxime.aripo_teure.iomanagement.StrFetch;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void startGame(String uiMethod, String language) throws Exception {
        //String language = System.getenv("LANG");
        if (StrFetch.chkLang(language)){
            GameLoop game = new GameLoop(uiMethod, language);
            game.start();
        }else{
            System.out.println("Language does not exist, choose between fr or en");
        }

    }

    public static void main(String[] args) throws Exception {
        String uiMethod= "cli";
        String language= "en";
        if(args.length > 0 ){
        if(args[0].equalsIgnoreCase("cli")){
            uiMethod = "cli";
        }else if(args[0].equalsIgnoreCase("gui")){
            uiMethod = "gui";
        }
        else{
            System.out.println("Start cli or gui ? [CLI/gui]");
            Scanner scan = new Scanner(System.in);
            if (scan.nextLine().equalsIgnoreCase("gui")){
                uiMethod = "gui";

            }else{
                uiMethod = "cli";
            }

        }
        }else {
            uiMethod = "cli";
        }

        if(args.length > 1 ) {
            language = args[1];
        } else{
            language = "en";
        }

        startGame(uiMethod, language);
    }
}