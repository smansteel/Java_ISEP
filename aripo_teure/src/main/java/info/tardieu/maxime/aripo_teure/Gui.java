package info.tardieu.maxime.aripo_teure;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Gui implements UserInteract {

    GuiExtended JFXImplementation;

    @Override
    public void start() throws Exception {
        this.JFXImplementation = new GuiExtended();
            this.JFXImplementation.demarre();

    }

    @Override
    public void displayStory(int id, String language){

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
}
