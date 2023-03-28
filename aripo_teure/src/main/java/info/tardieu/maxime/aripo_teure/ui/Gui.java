package info.tardieu.maxime.aripo_teure.ui;


import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.AbstractSpell;
import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.Actions;
import info.tardieu.maxime.aripo_teure.gameclasses.attributes.Potion;
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
    public Potion askPotion(Wizard player) {
        return null;
    }

    @Override
    public void displayInfos(Wizard player) {

    }
}
