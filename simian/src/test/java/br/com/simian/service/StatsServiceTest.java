package br.com.simian.service;

import br.com.simian.domain.Stats;
import br.com.simian.dto.StatsDTO;
import br.com.simian.repository.StatsRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatsServiceTest {

	@InjectMocks
	private StatsService statsService;
	
	@Mock
	private StatsRepository statsRepository;

	@Test
	public void testStats() {
		when(statsRepository.findAll()).thenReturn(Arrays.asList(
				new Stats(1L, false, ""), 
				new Stats(2L, false, ""),
				new Stats(3L, false, ""), 
				new Stats(4L, false, ""), 
				new Stats(5L, false, ""),
				new Stats(6L, false, ""), 
				new Stats(7L, false, ""), 
				new Stats(8L, false, ""),
				new Stats(9L, false, ""), 
				new Stats(10L, false, ""),
				new Stats(11L, true, ""), 
				new Stats(12L, true, ""),
				new Stats(13L, true, ""), 
				new Stats(14L, true, "")));

		StatsDTO statsDTO = statsService.find();
		assertEquals(10, statsDTO.getCountHumaDna());
		assertEquals(4, statsDTO.getCountMutantDna());
		assertEquals(0.4, statsDTO.getRatio());
	}

}
