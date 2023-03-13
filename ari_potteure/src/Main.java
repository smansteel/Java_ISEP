import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if(args[0].equalsIgnoreCase("cli")){
            System.out.println("Cli started");
        }else if(args[0].equalsIgnoreCase("gui")){
            System.out.println("Gui started");
        }
        else{
            System.out.println("Start cli or gui ? [CLI/gui]");
            Scanner scan = new Scanner(System.in);
            if (scan.nextLine().equalsIgnoreCase("gui")){
                System.out.println("Startig GUI");
            }else{
                System.out.println("Starting cli");
            }

        }
    }
}