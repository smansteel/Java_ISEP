package info.tardieu.maxime.aripo_teure.ui;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Item;
import info.tardieu.maxime.aripo_teure.gameclasses.storymanagement.Level;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;

public interface UserInteract {
    String language = "en";
    String playername = "Wizard";
    public void displayFromXML(int id);
    public void setPlayerName(String name);
    public int getMaxStoryid();
    public void displayMessage(String message);
    public void start() throws Exception;
    public String askName(String language);
    public void displaySpells(Wizard wiazrd);
    public Object askAction(Wizard player, AbstractEnemy[] enemies);
    public AbstractSpell askSpell(Wizard player);
    public Item askPotion(Wizard player);
    public void displayInfos(Wizard player);
    public void decorate(String message);
    public void decorateXML(int id);
    public void clrScrn();
    public void awaitEnter();
    public String askStringXML(int question);
    public AbstractEnemy whichEnemy(Level level);
    public void displayDamages(int damages);
    public void displayEnemyDamages(AbstractEnemy enemy, int damages);
    public void displayEnemyDeath(AbstractEnemy enemy);
    public void displayPlayerDeath(Wizard player, AbstractEnemy enemy);
    public boolean askAlliance();


}
