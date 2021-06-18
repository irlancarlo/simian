package br.com.simian.controller;



import java.util.Arrays;
import java.util.List;

import br.com.simian.domain.Stats;
import br.com.simian.dto.StatsDTO;
import br.com.simian.repository.StatsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.simian.SimianApplication;
import br.com.simian.dto.DnaDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SimianApplication.class)
@RunWith(SpringRunner.class)
public class StatsControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StatsRepository statsRepository;

    @Before
    public void setUp() {
        statsRepository.deleteAll();
        statsRepository.saveAll(Arrays.asList(
                new Stats( false, "A"),
                new Stats( false, "B"),
                new Stats( false, "C"),
                new Stats( false, "D"),
                new Stats( false, "E"),
                new Stats( false, "F"),
                new Stats( false, "G"),
                new Stats( false, "H"),
                new Stats( false, "I"),
                new Stats( false, "J"),
                new Stats( true, "K"),
                new Stats( true, "L"),
                new Stats( true, "M"),
                new Stats( true, "N")));


    }

    @Test
    public void isSimianTest() {
        DnaDTO request = new DnaDTO();
        List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
        request.setDna(dna);

        var statsDTO = restTemplate.getForObject("/stats", StatsDTO.class);
        assertEquals(10, statsDTO.getCountHumaDna());
        assertEquals(4, statsDTO.getCountMutantDna());
        assertEquals(0.4, statsDTO.getRatio());
    }




}
