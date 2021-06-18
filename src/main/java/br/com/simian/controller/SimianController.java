package br.com.simian.controller;

import br.com.simian.dto.DnaDTO;
import br.com.simian.exception.UnsupportedDNAException;
import br.com.simian.service.SimianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simian")
public class SimianController {

    @Autowired
    private SimianService simianService;

    @PostMapping
    public ResponseEntity<?> isSimian(@RequestBody DnaDTO dna) {

        if (!simianService.isSimian(dna)) {
            throw new UnsupportedDNAException();
        }

        return ResponseEntity.ok().build();
    }


}
