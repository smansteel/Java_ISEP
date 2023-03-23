package info.tardieu.maxime.aripo_teure.ui;


import info.tardieu.maxime.aripo_teure.iomanagement.StrFetch;

import java.util.Scanner;

public class Cli implements UserInteract {
    private String language;
    private Scanner scanner;
    private StrFetch fetcher;

    public Cli(String language) {
        this.language = language;
        scanner = new Scanner(System.in);
        fetcher = new StrFetch(this.language);
    }

    @Override
    public void displayFromXML(int id){
        displayMessage(fetcher.getString(id));




    }

    @Override
    public int getMaxStoryid(){
        return 0;
    }


    @Override
    public void displayMessage(String message){
        System.out.println(message);

    }

    @Override
    public void start(){
        System.out.println("Cli started");

    }

    @Override
    public String askName(String language) {
        StrFetch getter = new StrFetch(language);
        displayMessage(getter.getString(2));

        return scanner.next();
    }
}
