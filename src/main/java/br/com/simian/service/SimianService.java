package br.com.simian.service;

import org.springframework.stereotype.Service;

import br.com.simian.domain.Dna;
import br.com.simian.dto.DnaDTO;

@Service
public class SimianService {
	
	public boolean isSimian(DnaDTO dna) {
		
		return false;
	}
	
	public Dna findStats() {
		Dna dna = new Dna();
		dna.setCountHumanDna(100);
		dna.setCountMutantDna(40);
		double ratio = (double) dna.getCountMutantDna()/dna.getCountHumanDna();
		dna.setRatio(ratio);
		return dna;
	}

}
