package br.com.simian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.simian.domain.Population;
import br.com.simian.dto.DnaDTO;
import br.com.simian.repository.DnaRepository;

@Service
public class SimianService {
	
	@Autowired
	private DnaRepository dnaRepository;
	
	public boolean isSimian(DnaDTO dnaDTO) {
		
		Population dna = new Population();
		dna.setSimian(false);
	
		
		dnaRepository.save(dna);
		return dna.isSimian();
	}
	
	public List<Population> findStats() {
		Population dna = new Population();
		
		List<Population> findAll = dnaRepository.findAll();
	
		return findAll;
	}

}
