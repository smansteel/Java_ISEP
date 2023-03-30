package info.tardieu.maxime.aripo_teure.gameclasses;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Actions;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.HouseList;
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




    }
    public void next(){
        userInterface.clrScrn();
        if(nextTile > this.levels.length){
            endgame();
        }else{


        switch(this.levels[nextTile].getLevelType()) {
            case BOSS_FIGHT:
                userInterface.decorate(this.levels[nextTile].getStartString());


                bossFight(this.player,  this.levels[nextTile]);
                nextTile ++;

                break;
            case FIGHT:
                userInterface.displayMessage("w");
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
                        if(StorySpecials.checkSword((Item)object)){
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
        this.userInterface.displayFromXML(150);
        System.exit(0);
    }

    public void bossFight(Wizard player, Level level){
        AbstractEnemy lastenemy = level.getEnemies()[0];

        while(player.isAlive() && level.ennemiesAtLeastOneAlive()){
        boolean foundAction = false;

            Object action =  this.userInterface.askAction(player);

            if (action == Actions.FAIL || action == null){
                lastRoundPlayed = false;
            }else{
                lastRoundPlayed = true;
            }

            if (lastRoundPlayed){
                if(action instanceof AbstractSpell){
                    if(useSpell(action, level)){
                        continue;
                    }

                } else if (action instanceof Item converted) {
                    useItem(level, converted);
                }

                if (level.getRoomContent().length>0 ){
                    getItemsFromRoom(level);
                }
              clearEnemies(level);
            }
        }
        if(!level.ennemiesAtLeastOneAlive()){
            this.userInterface.displayMessage(level.getWinString());
        }
        if(!player.isAlive()){
            this.userInterface.displayPlayerDeath(player, lastenemy);
        }
    }

    private void getItemsFromRoom ( Level room){
        List<Object> roomContent= Arrays.asList(room.getRoomContent());
        int dropchances = 10;// outta 100
        if(random(0,100) <dropchances){
            Item randomItem = (Item) roomContent.get(random(0, room.getRoomContent().length));
            player.pickUp(randomItem);
            roomContent.remove(randomItem);
            room.setRoomContent(roomContent.toArray());

        }

    }
    private void clearEnemies(Level level){
        List<AbstractEnemy> templist = new ArrayList<>();
        for (AbstractEnemy enemy: level.getEnnemiesAsList()
        ) {
            if(enemy.isAlive()){
                this.userInterface.displayEnemyDamages(enemy, enemy.autoAttack(player));
                templist.add(enemy);
            }
        }
        level.setEnnemiesAsList(templist);
    }

    private void useItem(Level level, Item converted ){
        AbstractEnemy choice = this.userInterface.whichEnemy(level);
        int damages = player.usePotion(converted);
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
    }

    private boolean useSpell(Object action, Level level){
        AbstractSpell converted = (AbstractSpell) action;

        AbstractEnemy choice = this.userInterface.whichEnemy(level);
        if(choice == null){
            return true;
        }
        int damages = player.castSpell(converted, choice);
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
