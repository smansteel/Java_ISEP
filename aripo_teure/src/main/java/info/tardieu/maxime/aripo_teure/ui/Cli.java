package info.tardieu.maxime.aripo_teure.ui;


import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Actions;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Spells;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Potion;
import info.tardieu.maxime.aripo_teure.gameclasses.spell.Spell;
import info.tardieu.maxime.aripo_teure.gameclasses.storymanagement.Level;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;
import info.tardieu.maxime.aripo_teure.iomanagement.StrFetch;

import java.util.*;

public class Cli implements UserInteract {
    private String language;
    private Scanner scanner;
    private StrFetch fetcher;
    private String playername;

    public Cli(String language) {
        this.language = language;
        scanner = new Scanner(System.in);
        fetcher = new StrFetch(this.language);
    }

    @Override
    public void displayFromXML(int id){
        if(playername== null){
            playername ="Harry Potter";
        }
        displayMessage(fetcher.getString(id).replaceAll("!!player", this.playername));


    }

    @Override
    public void setPlayerName(String name) {
        this.playername = name;

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
    private String awaitAnswer(){
        if(playername== null){
            playername ="Harry Potter";
        }
        msgNNL(playername+"@home$ ");
        return scanner.next();
    }
    public void awaitEnter(){
        if(playername== null){
            playername ="Harry Potter";
        }
        displayMessage(fetcher.getString(26));
        msgNNL(playername+"@home$ ");
       scanner.hasNext();
    }

    @Override
    public String askName(String language) {
        decorateXML(12);

        return awaitAnswer();
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
            String message = "\t\t("+i+") "+choices[i];
            displayMessage(message);

        }
        boolean hasAnswered = false;
        while (!hasAnswered){
            int answer;
            try {
                answer = Math.abs(Integer.valueOf(awaitAnswer()));
            } catch(Exception error) {
                answer = -1;
            }


            if (0<=answer && answer<len){
                return answer;
            }
            else{
                displayMessage(fetcher.getString(20));

            }
        }
        return -1;
    }

    @Override
    public Object askAction(Wizard player) {
        int choice = askChoice(fetcher.getString(21), new String[]{fetcher.getString(22), fetcher.getString(23), fetcher.getString(25)});
        //displayMessage(String.valueOf(choice));
        switch (choice)
        {
            case 0: return askSpell(player);

            case 1: return Actions.POTION;

            case 2: displayInfos(player);
                return null;

            default:
                return Actions.FAIL;

        }
    }

    @Override
    public AbstractSpell askSpell(Wizard player) {

        if(  player.getKnownSpells().isEmpty()){
            displayFromXML(24);
            return null;
        }else{

            AbstractSpell[] knownSpells =  player.getKnownSpells().values().toArray(new AbstractSpell[0]);
        List<String> strlist = new ArrayList<String>();
        for (AbstractSpell spell : knownSpells
             ) {
            strlist.add(spell.getNameStr());
        }
        String[] nameArray= strlist.toArray(new String[0]);
        int choice = askChoice("wado", nameArray);

        return player.getKnownSpells().get(nameArray[choice]) ;}
    }

    @Override
    public Potion askPotion(Wizard player) {

        if(player.getKnownSpells().isEmpty()){
            displayFromXML(24);
            return null;
        }else{
            Potion[] knowSpells = (Potion[]) Collections.list(player.getPotions().elements()).toArray();
        List<String> strlist = null;
        for (Potion potion : knowSpells
        ) {
            strlist.add(potion.getName());
        }
        String[] nameArray= strlist.toArray(new String[0]);
        int choice = askChoice("wado", nameArray);

        return player.getPotions().get(nameArray[choice]) ;}
    }

    @Override
    public void displayInfos(Wizard player) {
        msgNNL("\n\n");
        displayMessage(fetcher.getString(30));
        msgNNL("\t");
        displayMessage(fetcher.getString(31)+  " : " + player.getName());
        msgNNL("\t");
        displayMessage(fetcher.getString(32)+  " : " + player.getHouse().getHouseIn());
        msgNNL("\t");
        displayMessage(fetcher.getString(33)+  " : " + player.getWand().getName());
        msgNNL("\t\t");
        displayMessage(fetcher.getString(34)+  " : " + player.getWand().getSize() + " cm");
        msgNNL("\t\t");
        displayMessage(fetcher.getString(35)+  " : " + player.getWand().getWood().toString());
        msgNNL("\t\t");
        displayMessage(fetcher.getString(36)+  " : " + player.getWand().getCore().toString());
        msgNNL("\n\n");

    }


    public void msgNNL(String message){
        System.out.print(message);
    }
    public void decorateXML(int id){
        String message = fetcher.getString(id);
        int length = message.length()+16;
        displayMessage("=".repeat(length));
        msgNNL("\t");
        displayMessage(message);
        displayMessage("=".repeat(length));
        msgNNL("\n\n");

    }
    public void decorate(String message){
        int length = message.length()+16;
        displayMessage("=".repeat(length));
        msgNNL("\t");
        displayMessage(message);
        displayMessage("=".repeat(length));
        msgNNL("\n\n");

    }
    public void clrScrn(){
        msgNNL("\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    @Override
    public String askStringXML(int question) {
        displayFromXML(question);
        return awaitAnswer();
    }

    @Override
    public AbstractEnemy whichEnemy(Level level) {
        List<String> question = new ArrayList<>();
        for (AbstractEnemy enemy: level.getEnemies()
             ) {
            question.add( enemy.getName()+ "(" + enemy.getHealth() +fetcher.getString(151)+")");
        }

        return level.getEnemies()[askChoice(fetcher.getString(150), question.toArray(new String[0]))];
    }

    @Override
    public void displayDamages(int damages) {
        msgNNL(fetcher.getString(120));
        msgNNL(String.valueOf(damages));
        msgNNL(fetcher.getString(121));



    }

    @Override
    public void displayEnemyDeath(AbstractEnemy enemy) {
        msgNNL(fetcher.getString(128)+" ");
        msgNNL(enemy.getName()+" ");
        msgNNL(fetcher.getString(129)+" ");
        msgNNL(String.valueOf(enemy.getMaxHealth())+" ");
        displayMessage(fetcher.getString(130));

    }

    @Override
    public void displayPlayerDeath(Wizard player, AbstractEnemy enemy) {
        msgNNL(fetcher.getString(123) +" ");
        msgNNL(String.valueOf(player.getMaxHealth())+" ");
        msgNNL(fetcher.getString(124)+" ");
        msgNNL(enemy.getName());
        msgNNL(".");

    }
}
