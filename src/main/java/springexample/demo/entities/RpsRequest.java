package springexample.demo.entities;

public class RpsRequest {

    private String userChoice;
    private boolean withWell;

    public RpsRequest(String userChoice, boolean withWell) {
        this.userChoice = userChoice;
        this.withWell = withWell;
    }

    public String getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    public boolean isWithWell() {
        return withWell;
    }

    public void setWithWell(boolean withWell) {
        this.withWell = withWell;
    }
}

