package br.com.simian.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
