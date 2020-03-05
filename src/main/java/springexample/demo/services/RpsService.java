package springexample.demo.services;

import org.springframework.stereotype.Service;
import springexample.demo.entities.RpsChoice;
import springexample.demo.entities.RpsRequest;
import springexample.demo.entities.RpsResponse;

import java.util.Arrays;
import java.util.List;

@Service
public class RpsService {

    private final static List<RpsChoice> allChoices = Arrays.asList(RpsChoice.ROCK, RpsChoice.PAPER, RpsChoice.SCISSORS, RpsChoice.WELL);


    public RpsResponse getWinner(RpsRequest requestData) throws IllegalArgumentException {
        try {
            RpsChoice userChoice = RpsChoice.valueOf(requestData.getUserChoice());
            RpsChoice computerChoice = makeRandomChoice(requestData.isWithWell());
            RpsResponse response = new RpsResponse();
            response.setUserChoice(userChoice);
            response.setComputerChoice(computerChoice);

            if (userChoice.equals(computerChoice)) {
                response.setWinner("DEUCE");
            } else {
                response.setWinner(calculateWinner(userChoice, computerChoice));
            }

            return response;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public RpsChoice makeRandomChoice(boolean withWell) {
        int random = withWell ? ((int) (Math.random() * 4)) : ((int) (Math.random() * 3));
        return allChoices.get(random);
    }

    private String calculateWinner(RpsChoice userInput, RpsChoice computerChoice) {
        if (getWinnersFromChoice(userInput).contains(computerChoice)) {
            return "YOU WON";
        } else {
            return "YOU LOST";
        }
    }

    private List<RpsChoice> getWinnersFromChoice(RpsChoice choice) {

        switch (choice) {
            case ROCK:
                return Arrays.asList(RpsChoice.SCISSORS);
            case PAPER:
                return Arrays.asList(RpsChoice.ROCK, RpsChoice.WELL);
            case SCISSORS:
                return Arrays.asList(RpsChoice.PAPER);
            default:
                return Arrays.asList(RpsChoice.SCISSORS, RpsChoice.ROCK);
        }
    }

}
