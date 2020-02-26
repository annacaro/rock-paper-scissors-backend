package springexample.demo.services;

import org.springframework.stereotype.Service;
import springexample.demo.entities.RpsChoice;
import springexample.demo.entities.RpsResponse;

import java.util.Arrays;
import java.util.List;

@Service
public class RpsService {

    private final List<RpsChoice> allChoices = Arrays.asList(RpsChoice.ROCK, RpsChoice.PAPER, RpsChoice.SCISSORS);


    public RpsResponse getWinner(RpsChoice userInput) {
        int random = (int) (Math.random() * 3);
        RpsResponse response = new RpsResponse();
        response.setUserChoice(userInput);
        response.setComputerChoice(allChoices.get(random));

        if (userInput.equals(allChoices.get(random))) {
            response.setWinner("DEUCE");
        } else {
            response.setWinner(calculateWinner(userInput, allChoices.get(random)));
        }

        return response;
    }

    private String calculateWinner(RpsChoice userInput, RpsChoice computerChoice) {
        if(computerChoice.equals(getWinnersFromChoice(userInput))) {
            return "YOU";
        } else {
            return "COMPUTER";
        }
    }

    private RpsChoice getWinnersFromChoice (RpsChoice choice) {

        switch (choice) {
            case ROCK:
                return RpsChoice.SCISSORS;
            case PAPER:
                return RpsChoice.ROCK;
            default:
                return RpsChoice.PAPER;
        }
    }

}
