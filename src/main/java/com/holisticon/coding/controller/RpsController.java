package com.holisticon.coding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.holisticon.coding.entities.RpsRequest;
import com.holisticon.coding.entities.RpsResponse;
import com.holisticon.coding.services.RpsService;

@RestController
@RequestMapping(path = "/play")
public class RpsController {

    @Autowired
    private RpsService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity play(
            @RequestBody RpsRequest userChoice)
            throws Exception {
        RpsResponse response = service.getWinner(userChoice);
        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please choose one of the following options: ROCK, PAPER, SCISSORS or WELL");
        } else {
            return ResponseEntity.ok(response);
        }

    }
}

