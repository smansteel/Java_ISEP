package info.tardieu.maxime.aripo_teure.gameclasses.storymanagement;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.Character;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.LevelType;

import java.util.Arrays;
import java.util.List;

public class Level {
    private AbstractEnemy[] enemies;
    private Character[] allies;
    private String startString;
    private String winString;
    private String lossString;
    private Object[] roomContent;
    public LevelType type;
    public Level(LevelType type) {
    this.type = type;
    }
    public Level fillBoss(Character[] allies, AbstractEnemy[] enemies, String startString, String winString, String lossString, Object[] roomContent) {
        this.allies = allies;
        this.enemies = enemies;
        this.startString = startString;
        this.winString = winString;
        this.lossString = lossString;
        this.roomContent = roomContent;
        return this;

    }

    public Level fillDisco(String startString, String endString,  Object[] roomContent){

        this.startString = startString;
        this.winString = endString;
        this.roomContent = roomContent;
        return this;
    }

    public LevelType getLevelType() {
        return type;
    }
    public String getStartString(){
        return this.startString;
    }

    public AbstractEnemy[] getEnemies() {
        return enemies;
    }
    public List<AbstractEnemy> getEnnemiesAsList(){
        return Arrays.asList(enemies);
    }

    public void setEnnemiesAsList(List<AbstractEnemy> enemies){
        this.enemies = enemies.toArray(new AbstractEnemy[0]);

    }

    public String getWinString() {
        return winString;
    }
    public String getEndString() {
        return winString;
    }

    public String getLossString() {
        return lossString;
    }

    public Object[] getRoomContent() {
        return roomContent;
    }
    public void setRoomContent(Object[] roomContent) {
        this.roomContent = roomContent;

    }

    public boolean ennemiesAtLeastOneAlive(){

        for (Character ennemy: this.enemies
             ) {
            if(ennemy.isAlive()){
                return true;
            }
        }
        return false;
    }
}
