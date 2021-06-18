package br.com.simian.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simian.domain.Stats;
import br.com.simian.dto.StatsDTO;
import br.com.simian.repository.StatsRepository;

@Service
public class StatsService {

	@Autowired
	private StatsRepository statsRepository;

	public void save(boolean isSimian, String dna) {
		statsRepository.save(new Stats(isSimian, dna));
	}

	public StatsDTO find() {

		StatsDTO dto = new StatsDTO();
		List<Stats> stats = statsRepository.findAll();

		int total = stats.size();
		int simian = (int) stats.stream().filter(Stats::isSimian).count();
		int human = total - simian;
		double ratio = simian;
		if (human > 0) {
			ratio = (double) simian / human;
		}

		dto.setCountHumaDna(human);
		dto.setCountMutantDna(simian);
		dto.setRatio(new BigDecimal(ratio).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
		return dto;

	}

}
