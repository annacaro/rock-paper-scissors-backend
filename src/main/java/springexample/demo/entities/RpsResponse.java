package springexample.demo.entities;

public class RpsResponse {

    RpsChoice userChoice;
    RpsChoice computerChoice;
    String winner;

    public RpsResponse() {
    }

    public RpsChoice getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(RpsChoice userChoice) {
        this.userChoice = userChoice;
    }

    public RpsChoice getComputerChoice() {
        return computerChoice;
    }

    public void setComputerChoice(RpsChoice computerChoice) {
        this.computerChoice = computerChoice;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}

