package info.tardieu.maxime.aripo_teure;

import java.io.IOException;

public interface UserInteract {
    String language = "en";
    public void displayStory(int id, String language);
    public int getMaxStoryid();
    public void displayMessage(String message);
    public void start() throws Exception;


}
