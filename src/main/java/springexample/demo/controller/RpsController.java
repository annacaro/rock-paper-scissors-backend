package springexample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springexample.demo.entities.RpsChoice;
import springexample.demo.entities.RpsResponse;
import springexample.demo.services.RpsService;

@RestController
public class RpsController {

    @Autowired
    private RpsService service;

    @RequestMapping("/play/{input}")
    public RpsResponse getWinner(@PathVariable("input") RpsChoice input) {
        return service.getWinner(input);
    }
}
