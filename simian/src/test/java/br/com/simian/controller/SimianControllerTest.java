package br.com.simian.controller;

import br.com.simian.SimianApplication;
import br.com.simian.dto.DnaDTO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SimianApplication.class)
@RunWith(SpringRunner.class)
public class SimianControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void isSimianTest() {
        DnaDTO request = new DnaDTO();
        List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
        request.setDna(dna);

        var response = restTemplate.postForEntity("/simian", request, Void.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void isHumanTest() {
        DnaDTO request = new DnaDTO();
        List<String> dna = Arrays.asList("ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTC");
        request.setDna(dna);

        var response = restTemplate.postForEntity("/simian", request, Void.class);
        Assertions.assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
    }

    @Test
    public void isSimianTestDuplicated() {
        DnaDTO request = new DnaDTO();
        List<String> dna = Arrays.asList("ATGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
        request.setDna(dna);

        restTemplate.postForEntity("/simian", request, Void.class);
        var response = restTemplate.postForEntity("/simian", request, Void.class);

        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

}