package info.tardieu.maxime.aripo_teure.ui;


import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractEnemy;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Item;
import info.tardieu.maxime.aripo_teure.gameclasses.storymanagement.Level;
import info.tardieu.maxime.aripo_teure.gameclasses.wizard.Wizard;

public class Gui implements UserInteract {

    GuiExtended JFXImplementation;

    @Override
    public void start() throws Exception {
        this.JFXImplementation = new GuiExtended();
            this.JFXImplementation.demarre();

    }

    @Override
    public void displayFromXML(int id){

    }

    @Override
    public void setPlayerName(String name) {

    }

    @Override
    public int getMaxStoryid(){
        return 0 ;
    }
    @Override
    public void displayMessage(String message){

    }

    /*  Sample code for SCQ  from awt :

        Frame f = new Frame();
        Choice test = new Choice();
        test.setBounds(100, 100, 75, 75);
        test.add("test");
        test.add("Item 2");
        f.add(test);
        // setting size, layout and visibility of frame
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

        */

    @Override
    public String askName(String language) {
        return language;
    }

    @Override
    public void displaySpells(Wizard wiazrd) {

    }

    @Override
    public Object askAction(Wizard player) {
        return null;
    }

    @Override
    public AbstractSpell askSpell(Wizard player) {
        return null;
    }

    @Override
    public Item askPotion(Wizard player) {
        return null;
    }

    @Override
    public void displayInfos(Wizard player) {

    }

    @Override
    public void decorate(String message) {

    }

    @Override
    public void decorateXML(int id) {

    }

    @Override
    public void clrScrn() {

    }

    @Override
    public void awaitEnter() {

    }

    @Override
    public String askStringXML(int question) {
        return null;
    }

    @Override
    public AbstractEnemy whichEnemy(Level level) {
        return null;
    }

    @Override
    public void displayDamages(int damages) {

    }

    @Override
    public void displayEnemyDamages(AbstractEnemy enemy, int damages) {

    }

    @Override
    public void displayEnemyDeath(AbstractEnemy enemy) {

    }

    @Override
    public void displayPlayerDeath(Wizard player, AbstractEnemy enemy) {

    }
}
