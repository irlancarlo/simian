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

		if (searchHorizontalDNA(dnaDTO.getDna()) || searchVerticalDNA(dnaDTO.getDna())
				|| searchDiagonalDNA(dnaDTO.getDna())) {
			dna.setSimian(true);
		}

		dnaRepository.save(dna);
		return dna.isSimian();
	}

	public boolean searchHorizontalDNA(List<String> dna) {
		for (String row : dna) {
			if (new String(row).contains("AAAA") || new String(row).contains("GGGG")
					|| new String(row).contains("CCCC")) {
				System.out.println("palavra: " + new String(row));
				return true;
			}
		}
		return false;
	}

	public boolean searchVerticalDNA(List<String> grid) {

		StringBuilder palavra = new StringBuilder();
		for (int i = 0, length = grid.get(0).length(); i < length; i++) {

			palavra = new StringBuilder();

			for (int k = 0; k < 6; k++) {
				char colChar = grid.get(k).charAt(i);

				if (palavra.isEmpty() || palavra.lastIndexOf(String.valueOf(colChar)) >= 0) {
					palavra.append(colChar);
				} else {
					palavra = new StringBuilder();
					palavra.append(colChar);
				}

				if (palavra.length() == 4) {
					System.out.println("palavra: " + palavra);
					return true;
				}
			}

		}

		return false;
	}

	public boolean searchDiagonalDNA(List<String> grid) {

		StringBuilder palavra = new StringBuilder();
		for (int i = 6; i > 0; i--) {

			palavra = new StringBuilder();

			for (int k = 0, l = i; k < 6 && l > 0; k++, l--) {
				char colChar = grid.get(k).charAt(l - 1);

				if (palavra.isEmpty() || palavra.lastIndexOf(String.valueOf(colChar)) >= 0) {
					palavra.append(colChar);
				} else {
					palavra = new StringBuilder();
					palavra.append(colChar);
				}

				if (palavra.length() == 4) {
					System.out.println("palavra: " + palavra);
					return true;
				}
			}

		}

		return false;
	}

	public List<Population> findStats() {

		List<Population> findAll = dnaRepository.findAll();
		// TODO implements query rn

		return findAll;
	}

}
