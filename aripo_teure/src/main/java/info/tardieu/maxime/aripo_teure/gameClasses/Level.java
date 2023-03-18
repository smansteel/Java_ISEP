package info.tardieu.maxime.aripo_teure.gameClasses;

import info.tardieu.maxime.aripo_teure.gameClasses.attributes.LevelType;

public class Level {
    private Character[] enemies;
    private Character[] allies;
    private String startString;
    private String winString;
    private String lossString;
    private Object[] roomContent;
    private LevelType type;
    public Level(LevelType type) {
    this.type = type;
    }
    public Level fillBoss(Character[] allies, Character[] enemies, String startString, String winString, String lossString, Object[] roomContent) {
        this.allies = allies;
        this.enemies = enemies;
        this.startString = startString;
        this.winString = winString;
        this.lossString = lossString;
        this.roomContent = roomContent;
        return this;

    }

}
