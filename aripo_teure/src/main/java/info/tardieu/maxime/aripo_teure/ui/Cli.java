package info.tardieu.maxime.aripo_teure.ui;


import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Actions;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Potion;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;
import info.tardieu.maxime.aripo_teure.iomanagement.StrFetch;

import java.util.Enumeration;
import java.util.Hashtable;
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
        displayMessage(getter.getString(12)  + " naem ?");

        return scanner.next();
    }

    @Override

    public void displaySpells(Wizard wizard){
        Hashtable<String, AbstractSpell> spells = wizard.getKnownSpells();
        Enumeration<String> enumerator = spells.keys();
        while (enumerator.hasMoreElements()) {

            // Getting the key of a particular entry
            enumerator.nextElement();

        }
    }
    private int askChoice(String question, String[] choices){
        displayMessage(question);
        int len = choices.length;
        for ( int i =0; i < len; i++
             ) {
            String message = "("+i+") "+choices[i];
            displayMessage(message);

        }
        boolean hasAnswered = false;
        while (!hasAnswered){
            int answer = Math.abs(Integer.valueOf(scanner.next()));
            if (answer<len){
                return answer;
            }
            else{
                displayMessage(fetcher.getString(20));

            }
        }
        return -1;
    }

    @Override
    public Actions askAction() {
        int choice = askChoice(fetcher.getString(21), new String[]{fetcher.getString(22), fetcher.getString(23)});
        displayMessage(String.valueOf(choice));
        switch (choice)
        {
            case 0: return Actions.SPELL;

            case 1: return Actions.POTION;

            default:
                return Actions.FAIL;

        }
    }

    @Override
    public AbstractSpell askSpell() {
        return null;
    }

    @Override
    public Potion askPotion() {
        return null;
    }
}
