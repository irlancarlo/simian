package br.com.simian.controller;

import br.com.simian.dto.StatsDTO;
import br.com.simian.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping
    public StatsDTO findStatsDna() {
        return statsService.find();
    }

}
