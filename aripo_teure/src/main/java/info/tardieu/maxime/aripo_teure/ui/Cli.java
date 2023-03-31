package info.tardieu.maxime.aripo_teure.ui;


import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Actions;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Item;
import info.tardieu.maxime.aripo_teure.gameclasses.storymanagement.Level;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;
import info.tardieu.maxime.aripo_teure.iomanagement.StrFetch;

import java.util.*;

import static java.lang.Thread.sleep;

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
        try {
            scanner.nextLine();
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(playername== null){
            playername ="Harry Potter";
        }
        msgNNL(fetcher.getString(26));
        msgNNL(" -->");
        scanner.nextLine();;
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
    private int askChoice(String question, String[] choices, boolean goBack){
        displayMessage(question);
        int len = choices.length;
        int i;
        for ( i =0; i < len; i++
             ) {
            String message = "\t\t("+i+") "+choices[i];
            displayMessage(message);

        }
        if (goBack)
        {
            String message = "\t\t("+i+") "+ fetcher.getString(131);
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


            if (0<=answer && answer<=len){
                return answer;
            }
            else{
                displayMessage(fetcher.getString(20));

            }
        }
        return -1;
    }

    @Override
    public Object askAction(Wizard player, AbstractEnemy[] enemies) {
        int choice = askChoice(fetcher.getString(21), new String[]{fetcher.getString(22), fetcher.getString(23), fetcher.getString(25), fetcher.getString(28)}, true);
        //displayMessage(String.valueOf(choice));
        if(System.getenv("env")!= null && System.getenv("env").equals("DEBUG")){
            displayFight(player, enemies);
        }

        switch (choice)
        {
            case 0: return askSpell(player);

            case 1: return askPotion(player);

            case 3: displayFight(player, enemies);
                return null;

            case 2: displayInfos(player);
                return null;

            default:
                return Actions.FAIL;

        }
    }

    private void displayFight(Wizard player,AbstractEnemy[] enemies){
        msgNNL("\n\n");
        displayMessage(fetcher.getString(152));
        msgNNL("\t");
        msgNNL(fetcher.getString(153)+  ": " + player.getHealth() +  "/ " + player.getMaxHealth());
        msgNNL("\n");

        for (AbstractEnemy enemy:enemies
             ) {
            displayMessage(fetcher.getString(155)+  ": " + enemy.getName());
            msgNNL("\t");
            msgNNL(fetcher.getString(156)+  ": " + enemy.getHealth() + " / " + enemy.getMaxHealth());
            msgNNL("\n");

        }
        msgNNL("\n");


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
        int choice = askChoice(fetcher.getString(118), nameArray, true);
            if(choice == nameArray.length){
                return null;
            }

        return player.getKnownSpells().get(nameArray[choice]) ;}
    }

    @Override
    public Item askPotion(Wizard player) {

        if(player.getPotions().isEmpty()){
            displayFromXML(27);
            return null;
        }else{
            Item[] knowSpells = player.getPotions().values().toArray(new Item[0]);
            List<String> strlist = new ArrayList<String>();
        for (Item item : knowSpells
        ) {
            strlist.add(item.getName());
        }
        String[] nameArray= strlist.toArray(new String[0]);
        int choice = askChoice(fetcher.getString(119), nameArray, true);
        if(choice == nameArray.length){
            return null;
        }

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
        msgNNL("\n\n");
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
        int choice = askChoice(fetcher.getString(150), question.toArray(new String[0]), true);
        if(choice == level.getEnemies().length){
            return null;
        }

        return level.getEnemies()[choice];
    }

    @Override
    public void displayDamages(int damages) {
        msgNNL(fetcher.getString(120) +" ");
        msgNNL(String.valueOf(damages)+" ");
        displayMessage(fetcher.getString(121));
        displayMessage("");



    }

    @Override
    public void displayEnemyDamages(AbstractEnemy enemy, int damages) {
        msgNNL(fetcher.getString(124) +" ");
        msgNNL(enemy.getName() +" ");
        msgNNL(fetcher.getString(125) +" ");
        msgNNL(String.valueOf(damages)+" ");
        displayMessage(fetcher.getString(121));
        displayMessage("");
    }

    @Override
    public void displayEnemyDeath(AbstractEnemy enemy) {
        msgNNL(fetcher.getString(128)+" ");
        msgNNL(enemy.getName()+" ");
        msgNNL(fetcher.getString(129)+" ");
        msgNNL(String.valueOf(enemy.getMaxHealth())+" ");
        displayMessage(fetcher.getString(130));
        displayMessage("");

    }

    @Override
    public void displayPlayerDeath(Wizard player, AbstractEnemy enemy) {
        msgNNL(fetcher.getString(123) +" ");
        msgNNL(String.valueOf(player.getMaxHealth())+" ");
        msgNNL(fetcher.getString(126)+" ");
        msgNNL(enemy.getName());
        msgNNL(".");

    }

    @Override
    public boolean askAlliance() {
        int choice = askChoice(fetcher.getString(139), new String[]{fetcher.getString(140), fetcher.getString(141)}, false);
        if (choice == 0){
            return true;
        }
        return false;
    }
}
