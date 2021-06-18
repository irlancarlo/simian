package br.com.simian.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Stats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "is_simian", nullable = false)
	private boolean isSimian;
	
	@Column(unique = true)
	private String dna; 

	public Stats(boolean isSimian, String dna) {
		this.isSimian = isSimian;
		this.dna = dna;
	}

}
