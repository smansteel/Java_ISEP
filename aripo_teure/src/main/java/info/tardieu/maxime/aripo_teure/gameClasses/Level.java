package info.tardieu.maxime.aripo_teure.gameClasses;

public class Level {
    private Character[] enemies;
    private Character[] allies;
    private String startString;
    private String winString;
    private String lossString;
    public Level(Character[] allies, Character[] enemies, String startString, String winString, String lossString) {
        this.allies = allies;
        this.enemies = enemies;
        this.startString = startString;
        this.winString = winString;
        this.lossString = lossString;


    }

}
