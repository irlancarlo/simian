package br.com.simian.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DnaService {

	public boolean isSimian(List<String> dna) {

		if (searchHorizontalDNA(dna) || searchVerticalDNA(dna) || searchDiagonalDNA(dna)) {
			return true;
		}

		return false;
	}

	private boolean hasSequence(String sequence) {

		return sequence.contains("AAAA") || sequence.contains("GGGG") || sequence.contains("CCCC")
				|| sequence.contains("TTTT");
	}

	private boolean searchHorizontalDNA(List<String> dna) {
		for (String row : dna) {
			if (hasSequence(row)) {
				System.out.println("palavra: " + row);
				return true;
			}
		}
		return false;
	}

	private boolean searchVerticalDNA(List<String> grid) {

		StringBuilder word;

		for (int col = 0; col < grid.get(0).length(); col++) {

			word = new StringBuilder();

			for (int row = 0; row < grid.size(); row++) {
				char colChar = grid.get(row).charAt(col);

				word.append(colChar);

			}

			if (hasSequence(word.toString())) {
				return true;
			}

		}

		return false;
	}

	private boolean searchDiagonalDNA(List<String> grid) {

		StringBuilder word = new StringBuilder();
		for (int i = 6; i > 0; i--) {

			word = new StringBuilder();

			for (int k = 0, l = i; k < 6 && l > 0; k++, l--) {
				char colChar = grid.get(k).charAt(l - 1);

				if (word.length() == 0 || word.lastIndexOf(String.valueOf(colChar)) >= 0) {
					word.append(colChar);
				} else {
					word = new StringBuilder();
					word.append(colChar);
				}

				if (word.length() == 4) {
					System.out.println("palavra: " + word);
					return true;
				}
			}

		}

		return false;
	}

}
