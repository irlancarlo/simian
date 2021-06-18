package br.com.simian.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DnaServiceTest {
	
	@InjectMocks
	private DnaService dnaService;

	@Test
	public void testIsSimian() {

		List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
		Assert.assertTrue(dnaService.isSimian(dna));

	}

	@Test
	public void testIsHuman() {

		List<String> dna = Arrays.asList("ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTC");
		Assert.assertFalse(dnaService.isSimian(dna));

	}

	@Test
	public void testSearchHorizontalDNAWithDNAHuman() {

		List<String> dna = Arrays.asList("ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTC");
		Assert.assertFalse(dnaService.isSimian(dna));

	}

	@Test
	public void testSearchHorizontalDNABeginDNA() {

		List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
		Assert.assertTrue(dnaService.isSimian(dna));

	}

	@Test
	public void testSearchHorizontalDNAEndDNA() {

		List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "ATCCCC", "TCACTG");
		Assert.assertTrue(dnaService.isSimian(dna));

	}

	@Test
	public void testSearchVerticalDNAWithDNAHuman() {

		List<String> dna = Arrays.asList("ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTC");
		Assert.assertFalse(dnaService.isSimian(dna));

	}

	@Test
	public void testSearchVerticalDNABeginDNA() {

		List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
		Assert.assertTrue(dnaService.isSimian(dna));

	}

	@Test
	public void testSearchVerticalDNAEndDNA() {

		List<String> dna = Arrays.asList("CTGATA", "CTATTC", "TATTGT", "AGAGGG", "CCCCGA", "TCACGG");
		Assert.assertTrue(dnaService.isSimian(dna));

	}

	@Test
	public void testSearchDiagonalDNAWithDNAHuman() {

		List<String> dna = Arrays.asList("ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTC");
		Assert.assertFalse(dnaService.isSimian(dna));

	}

	@Test
	public void testSearchDiagonalDNABeginDNA() {

		List<String> dna = Arrays.asList("CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG");
		Assert.assertTrue(dnaService.isSimian(dna));

	}

	@Test
	public void testSearchDiagonalDNAEndDNA() {

		List<String> dna = Arrays.asList("CCCCTA", "TCACTG", "CTGAGA", "CTATGC", "TATTGT", "AGAGGG");
		Assert.assertTrue(dnaService.isSimian(dna));

	}

}
