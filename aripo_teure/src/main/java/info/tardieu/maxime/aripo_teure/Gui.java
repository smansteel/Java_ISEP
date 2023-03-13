package info.tardieu.maxime.aripo_teure;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Gui extends Application implements UserInteract {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(info.tardieu.maxime.aripo_teure.HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void displayStory(int level, int stage){
        int papte = level;
        int papte2 = stage;

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
