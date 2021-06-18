package br.com.simian.service;

import br.com.simian.dto.DnaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SimianService {

    @Autowired
    private StatsService statsService;

    @Autowired
    private DnaService dnaService;

    public boolean isSimian(DnaDTO dnaDTO) {
        boolean isSimian = dnaService.isSimian(dnaDTO.getDna());

        statsService.save(isSimian, dnaDTO.getDna().stream().collect(Collectors.joining()));

        return isSimian;
    }

}
