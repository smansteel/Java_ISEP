package info.tardieu.maxime.aripo_teure;

import java.io.IOException;

public interface UserInteract {
    String language = "en";
    public void displayStory(int level, int stage);
    public void displayMessage(String message);
    public void start() throws Exception;


}
