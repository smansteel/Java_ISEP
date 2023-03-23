package info.tardieu.maxime.aripo_teure.ui;


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
}
