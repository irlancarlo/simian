package br.com.simian.simian;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.simian.dto.DnaDTO;
import br.com.simian.service.SimianService;

@SpringBootTest
class SimianApplicationTests {

	@Autowired
	private SimianService simianService;
	
	@Test
	void testIsSimian() {

		List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
		DnaDTO dtoDNA = new DnaDTO();
		dtoDNA.setDna(dna);

		Assert.assertTrue(simianService.isSimian(dtoDNA));

	}
	
	@Test
	void testIsHuman() {

		List<String> dna = Arrays.asList("ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTC");
		DnaDTO dtoDNA = new DnaDTO();
		dtoDNA.setDna(dna);

		Assert.assertFalse(simianService.isSimian(dtoDNA));

	}
	
	@Test
	void testSearchHorizontalDNAWithDNAHuman() {

		List<String> dna = Arrays.asList("ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTC");

		Assert.assertFalse(simianService.searchHorizontalDNA(dna));

	}

	@Test
	void testSearchHorizontalDNABeginDNA() {

		List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");

		Assert.assertTrue(simianService.searchHorizontalDNA(dna));

	}
	
	@Test
	void testSearchHorizontalDNAEndDNA() {

		List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "ATCCCC", "TCACTG");

		Assert.assertTrue(simianService.searchHorizontalDNA(dna));

	}
	
	@Test
	void testSearchVerticalDNAWithDNAHuman() {

		List<String> dna = Arrays.asList("ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTC");

		Assert.assertFalse(simianService.searchVerticalDNA(dna));

	}
	
	@Test
	void testSearchVerticalDNABeginDNA() {

		List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");

		Assert.assertTrue(simianService.searchVerticalDNA(dna));

	}
	
	@Test
	void testSearchVerticalDNAEndDNA() {

		List<String> dna = Arrays.asList("CTGATA", "CTATTC", "TATTGT", "AGAGGG", "CCCCGA", "TCACGG");

		Assert.assertTrue(simianService.searchVerticalDNA(dna));

	}
	
	@Test
	void testSearchDiagonalDNAWithDNAHuman() {

		List<String> dna = Arrays.asList("ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTC");

		Assert.assertFalse(simianService.searchDiagonalDNA(dna));

	}
	
	@Test
	void testSearchDiagonalDNABeginDNA() {

		List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");

		Assert.assertTrue(simianService.searchDiagonalDNA(dna));

	}
	
	@Test
	void testSearchDiagonalDNAEndDNA() {

		List<String> dna = Arrays.asList("CCCCTA", "TCACTG", "CTGAGA", "CTATGC", "TATTGT", "AGAGGG");

		Assert.assertTrue(simianService.searchDiagonalDNA(dna));

	}

}
