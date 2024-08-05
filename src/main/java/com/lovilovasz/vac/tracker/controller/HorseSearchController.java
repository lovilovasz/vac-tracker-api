package com.lovilovasz.vac.tracker.controller;

import com.lovilovasz.vac.tracker.domain.horse.HorseResponse;
import com.lovilovasz.vac.tracker.service.HorseSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HorseSearchController {
    @Autowired
    HorseSearchService horseSearchService;

    @GetMapping("/horseSearch/{horseName}")
    public HorseResponse searchForHorse(@PathVariable String horseName) {
        return horseSearchService.searchHorse(horseName);
    }
}
