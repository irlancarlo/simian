package br.com.simian.service;

import br.com.simian.service.enums.SequenceDNA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnaService {

    public boolean isSimian(List<String> dna) {

        if (searchHorizontalDNA(dna) || searchVerticalDNA(dna) || searchDiagonalDNA(dna)) {
            return true;
        }

        return false;
    }

    private boolean hasSequence(String sequence) {

        for (SequenceDNA sequenceDNA : SequenceDNA.values()) {
            if (sequence.contains(sequenceDNA.name())) {
                return true;
            }
        }

        return false;
    }

    private boolean searchHorizontalDNA(List<String> dna) {
        for (String row : dna) {
            if (hasSequence(row)) {
                return true;
            }
        }
        return false;
    }

    private boolean searchVerticalDNA(List<String> dna) {

        StringBuilder word;

        for (int col = 0; col < dna.get(0).length(); col++) {

            word = new StringBuilder();

            for (int row = 0; row < dna.size(); row++) {
                char colChar = dna.get(row).charAt(col);
                word.append(colChar);

                if (hasSequence(word.toString())) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean searchDiagonalDNA(List<String> dna) {

        StringBuilder word;
        for (int col = dna.get(0).length(); col > 0; col--) {

            word = new StringBuilder();

            for (int row = 0, diagonal = col; row < dna.size() && diagonal > 0; row++, diagonal--) {

                char colChar = dna.get(row).charAt(diagonal - 1);
                word.append(colChar);

                if (hasSequence(word.toString())) {
                    return true;
                }
            }
        }

        return false;
    }

}
