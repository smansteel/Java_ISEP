package info.tardieu.maxime.aripo_teure.ui;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Actions;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Potion;
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
    public Object askAction(Wizard player);
    public AbstractSpell askSpell(Wizard player);
    public Potion askPotion(Wizard player);
    public void displayInfos(Wizard player);


}
