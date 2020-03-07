package com.holisticon.coding.services;

import com.holisticon.coding.entities.RpsChoice;
import com.holisticon.coding.entities.RpsRequest;
import com.holisticon.coding.entities.RpsResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * This service contains all choices for a rock paper scissors game and calculates the winner between two choices.
 */
@Service
public class RpsService {

    /**
     * A list that contains all possible choices for a game.
     */
    private final static List<RpsChoice> allChoices = Arrays.asList(RpsChoice.ROCK, RpsChoice.PAPER, RpsChoice.SCISSORS, RpsChoice.WELL);


    /**
     * This method first calls a method to make a random choice and calculates the winner.
     * @param requestData The data send form the frontend that contains the choice of the user and if well is an option or not
     * @return an optional of the winner object
     * @throws IllegalArgumentException Exception is thrown when the user sent an invalid choice
     */
    public Optional<RpsResponse> getWinner(RpsRequest requestData) throws IllegalArgumentException {
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

            return Optional.of(response);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    /**
     * This method calculates a random integer in order to extract a random choice.
     * @param withWell if the game is played with the option well or not
     * @return the random choice
     */
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
