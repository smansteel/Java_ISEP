package info.tardieu.maxime.aripo_teure.ui;

public interface UserInteract {
    String language = "en";
    public void displayFromXML(int id);
    public int getMaxStoryid();
    public void displayMessage(String message);
    public void start() throws Exception;
    public String askName(String language);

}
