package br.com.simian.dto;

import lombok.Data;

@Data
public class StatsDTO {
	
	private int countMutantDna;
	private int countHumaDna;
	private double ratio;

}
