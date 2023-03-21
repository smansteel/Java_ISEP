package info.tardieu.maxime.aripo_teure;


public class Cli implements UserInteract{
    private String language;

    public Cli(String language) {
        this.language = language;
    }

    @Override
    public void displayStory(int id, String language){



    }

    @Override
    public int getMaxStoryid(){
        return 0;
    }


    @Override
    public void displayMessage(String message){
        System.out.println(message);

    }

    @Override
    public void start(){
        System.out.println("Cli started");

    }

}
