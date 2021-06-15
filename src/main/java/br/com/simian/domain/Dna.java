package br.com.simian.domain;

import java.io.Serializable;

import lombok.Data;


@Data
public class Dna implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private int countMutantDna;
	private int countHumanDna;
	private double ratio;
	

}
