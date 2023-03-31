package info.tardieu.maxime.aripo_teure.gameclasses;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Actions;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Bosses;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.HouseList;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Spells;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Item;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;
import info.tardieu.maxime.aripo_teure.ui.UserInteract;
import info.tardieu.maxime.aripo_teure.gameclasses.storymanagement.Level;
import info.tardieu.maxime.aripo_teure.gameclasses.storymanagement.StoryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static info.tardieu.maxime.aripo_teure.utils.Random.random;

public class GameTurn {
    private Wizard player;
    private String language;
    private UserInteract userInterface;
    private int nextTile;
    private boolean lastRoundPlayed;
    int atkCount;
    private Level[] levels;
    public void start(String language, UserInteract userInterface){
        this.player = new Wizard();
        this.language = language;
        String name = userInterface.askName(this.language);
        String wandName = userInterface.askStringXML(13);
        this.player.setWandName(wandName);
        this.player.setName(name) ;
        this.levels = StoryBuilder.getLevels(language);
        //userInterface.displayMessage(name);
        this.userInterface = userInterface;
        this.userInterface.setPlayerName(name);
        nextTile =0;

        this.levels =  StoryBuilder.getLevels(this.language);
        this.userInterface.displayInfos(player);




    }
    public void next(){
        userInterface.clrScrn();
        if(nextTile > this.levels.length){
            endgame();
        }else{


        switch(this.levels[nextTile].getLevelType()) {
            case BOSS_FIGHT:
                userInterface.decorate(this.levels[nextTile].getStartString());


                bossFight();
                playerUpgrade();
                nextTile ++;

                break;
            case FIGHT:

                userInterface.displayMessage(this.levels[nextTile].getStartString());
                nextTile ++;
                break;
            case DISCOVERY:
                userInterface.displayMessage(this.levels[nextTile].getStartString());
                for (Object object: this.levels[nextTile].getRoomContent()
                     ) {
                    if (object instanceof  AbstractSpell){
                        player.learn(( AbstractSpell )object);

                    } else if (object instanceof Item) {
                        if(StorySpecials.checkBook((Item)object)){
                            if (player.getHouse().getHouseIn().equals(HouseList.Gryffindor)){
                                this.userInterface.displayFromXML(59);
                                player.pickUp( (Item) object);
                            }

                        } else{
                        player.pickUp( (Item) object);}
                    }
                }

                userInterface.displayMessage(this.levels[nextTile].getEndString());
                userInterface.awaitEnter();
                nextTile ++;
                break;
        }
        }




    }

    public void endgame(){
        this.userInterface.displayFromXML(148);
        System.exit(0);
    }
    public void endgame(boolean val){
        this.userInterface.displayFromXML(149);
        System.exit(0);
    }

    public void playerUpgrade(){
        Actions upgrade = this.userInterface.askUpgarde();
        if(upgrade ==Actions.UPGRADE_DAMAGES){
            player.setDamage(player.getDamage()+10);
        }else if(upgrade ==Actions.UPGRADE_HEALTH){
            player.setMaxHealth(player.getMaxHealth()+50);
            player.setHealth(player.getHealth()+50);
        }

        this.userInterface.displayUpgrade(upgrade, player);

    }



    public void bossFight(){
        AbstractEnemy lastenemy = this.levels[nextTile].getEnemies()[0];

        while(player.isAlive() && this.levels[nextTile].ennemiesAtLeastOneAlive()){
            player.setDefending(false);

            Object action;
            if(StorySpecials.checkDeathEaterAlliance(player,this.levels[nextTile].getEnemies()[0] )){
                if (this.userInterface.askAlliance()){
                    action = Actions.ALLIANCE;
                }
                else{
                    action = Actions.FAIL;
                }
            }else{
                action =  this.userInterface.askAction(player, this.levels[nextTile]);
            }


            if (action == Actions.FAIL || action == null){
                lastRoundPlayed = false;
            }else if (action == Actions.ALLIANCE){
                lastRoundPlayed = false;

                this.userInterface.displayFromXML(143);
                for (AbstractEnemy enemy: this.levels[nextTile].getEnemies()
                ) {
                    enemy.kill();
                }
                this.endgame();

            }else{
                lastRoundPlayed = true;
            }

            if (lastRoundPlayed){
                if(action instanceof AbstractSpell){
                    if(useSpell(action)){
                        continue;
                    }

                } else if (action instanceof Item converted) {
                    useItem( converted);
                }
                else if (action instanceof AbstractEnemy converted) {
                    player.attack( converted, player.getDamage());
                    this.userInterface.displayDamages(player.getDamage());
                }

                if (this.levels[nextTile].getRoomContent().length>0 ){
                    getItemsFromRoom(this.levels[nextTile]);
                }
              attackAndClearEnemies();
            }
        }
        if(!this.levels[nextTile].ennemiesAtLeastOneAlive()){
            this.userInterface.displayMessage(this.levels[nextTile].getWinString());
        }
        if(!player.isAlive()){
            this.userInterface.displayPlayerDeath(player, lastenemy);
            endgame(false);
        }
    }

    private void getItemsFromRoom ( Level room){
        ArrayList<Object> roomContent= new ArrayList<>(Arrays.asList(room.getRoomContent()));
        int dropchances = 10;//% of chances to drop the item
        if(random(0,100) <dropchances && roomContent.size()>=1){
            int randomize = random(0, room.getRoomContent().length-1);
            Item randomItem = (Item) roomContent.remove(randomize);
            this.userInterface.displayFromXML(85);
            player.pickUp(randomItem);
            room.setRoomContent(roomContent.toArray());

        }

    }
    private void attackAndClearEnemies(){
        List<AbstractEnemy> templist = new ArrayList<>();
        for (AbstractEnemy enemy: this.levels[nextTile].getEnnemiesAsList()
        ) {

            if(enemy.isAlive()){
                this.userInterface.displayEnemyDamages(enemy, enemy.autoAttack(player));
                templist.add(enemy);
            }
        }
        this.levels[nextTile].setEnnemiesAsList(templist);
    }

    private void useItem(Item converted ){

        int damages;
        AbstractEnemy choice ;
        if (this.levels[nextTile].getEnemies().length > 1){
            choice = this.userInterface.whichEnemy(this.levels[nextTile]);
        }else{
             choice = this.levels[nextTile].getEnemies()[0];
        }

        if(StorySpecials.checkBook(converted) && choice.getType() == Bosses.BASILISK){
            choice.kill();
            damages = -2;

        }  else if (StorySpecials.checkFireworks(converted) && choice.getType() == Bosses.UMBRIDGE)  {
            choice.kill();
            damages = -2;


        }else{
            damages = player.usePotion(converted);

        }

        if (damages >=0 && choice.isAlive()){
            this.userInterface.displayDamages(damages);

        } else if (damages >=0 && !choice.isAlive()){
            this.userInterface.displayEnemyDeath(choice);

        } else if (damages == -2) {
            if (!choice.isAlive()){
                this.userInterface.displayEnemyDeath(choice);
            }

        }else if(damages == -1){
            this.userInterface.displayFromXML(134);
        }
    }

    private boolean useSpell(Object action){
        AbstractSpell converted = (AbstractSpell) action;
        AbstractEnemy choice ;
        if (this.levels[nextTile].getEnemies().length > 1){
            choice = this.userInterface.whichEnemy(this.levels[nextTile]);
        }else{
            choice = this.levels[nextTile].getEnemies()[0];
        }
        if(choice == null){
            return true;
        }
        int damages;

        if (StorySpecials.checkTrollInteraction(choice, converted)){
            this.userInterface.displayFromXML(135);
            choice.kill();
            damages = -2;

        }
        if (converted.getName() == Spells.PROTEGO){
            this.userInterface.displayFromXML(4);
            player.defend();
            damages = 0;

        }
        else if (converted.getName() == Spells.EXPECTO_PATRONUM){
            this.userInterface.displayFromXML(5);
            player.setDamageReduction(75);
            damages = 0;

        }
        if (StorySpecials.checkPettigrowInteraction( choice, converted)){

            atkCount++;
            if(atkCount >3){

                this.userInterface.displayFromXML(137);
                choice.kill();

                damages = -3;

            }else{
                this.userInterface.displayFromXML(138);
                damages= 0;
            }


        }else if (StorySpecials.checkDementorInteraction( choice, converted)){
            this.userInterface.displayFromXML(136);
            for (AbstractEnemy enemy: this.levels[nextTile].getEnemies()
            ) {
                enemy.kill();
            }

            damages = -3;


        }else{
            damages = player.castSpell(converted, choice);
        }



        if (damages >=0 && choice.isAlive()){
            this.userInterface.displayDamages(damages);

        } else if (damages >=0 && !choice.isAlive()){
            this.userInterface.displayEnemyDeath(choice);

        } else if (damages == -2) {
            if (!choice.isAlive()){
                this.userInterface.displayEnemyDeath(choice);
            }

        }else if(damages == -1){
            this.userInterface.displayFromXML(133);
        }
        return false;
    }

}
