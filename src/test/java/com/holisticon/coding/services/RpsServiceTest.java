package com.holisticon.coding.services;

import com.holisticon.coding.entities.RpsRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.holisticon.coding.entities.RpsChoice;
import com.holisticon.coding.entities.RpsResponse;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class RpsServiceTest {

    @Mock
    RpsService serviceUnderTest = new RpsService();

    @BeforeEach
    public void initMock() {
        Mockito.when(serviceUnderTest.getWinner(any(RpsRequest.class))).thenCallRealMethod();
    }

    @Test
    public void getWinnerFromRockAndPaper() {
        Mockito.when(serviceUnderTest.makeRandomChoice(anyBoolean())).thenReturn(RpsChoice.ROCK);
        RpsRequest request = new RpsRequest("PAPER", false);
        RpsResponse response = serviceUnderTest.getWinner(request);
        Assertions.assertEquals("YOU WON", response.getWinner());
    }

    @Test
    public void getWinnerFromRockAndRock() {
        Mockito.when(serviceUnderTest.makeRandomChoice(anyBoolean())).thenReturn(RpsChoice.ROCK);
        RpsRequest request = new RpsRequest("ROCK", false);
        RpsResponse response = serviceUnderTest.getWinner(request);
        Assertions.assertEquals("DEUCE", response.getWinner());
    }

    @Test
    public void getWinnerFromRockAndScissors() {
        Mockito.when(serviceUnderTest.makeRandomChoice(anyBoolean())).thenReturn(RpsChoice.ROCK);
        RpsRequest request = new RpsRequest("SCISSORS", false);
        RpsResponse response = serviceUnderTest.getWinner(request);
        Assertions.assertEquals("YOU LOST", response.getWinner());
    }

    @Test
    public void getWinnerFromRockAndWell() {
        Mockito.when(serviceUnderTest.makeRandomChoice(anyBoolean())).thenReturn(RpsChoice.ROCK);
        RpsRequest request = new RpsRequest("WELL", true);
        RpsResponse response = serviceUnderTest.getWinner(request);
        Assertions.assertEquals("YOU WON", response.getWinner());
    }

    @Test
    public void getWinnerWithInvalidChoice() {
        RpsRequest request = new RpsRequest("Paper", false);
        RpsResponse response = serviceUnderTest.getWinner(request);
        Assertions.assertNull(response);
    }
}
