package com.lovilovasz.vac.tracker.controller;

import com.lovilovasz.vac.tracker.domain.horse.HorseResponse;
import com.lovilovasz.vac.tracker.domain.horse.HorseSearchParams;
import com.lovilovasz.vac.tracker.service.HorseSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HorseSearchController {
    @Autowired
    HorseSearchService horseSearchService;

    @PostMapping("/horseSearch")
    public HorseResponse searchForHorse(@RequestBody HorseSearchParams horseSearchParams) {
        return horseSearchService.searchHorse(horseSearchParams);
    }
}
