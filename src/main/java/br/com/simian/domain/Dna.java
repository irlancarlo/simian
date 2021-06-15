package br.com.simian.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Dna implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Getter
	@Setter
	private int countMutantDna;
	
	@Getter
	@Setter
	private int countHumanDna;
	
	@Getter
	@Setter
	private double ratio;
	

}
