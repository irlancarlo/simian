package br.com.simian.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.simian.domain.Population;
import br.com.simian.dto.DnaDTO;
import br.com.simian.resource.exception.UnsupportedDNAException;
import br.com.simian.service.SimianService;

@RestController
@RequestMapping("/simian")
public class SimianResource {

	@Autowired
	private SimianService simianService;

	@PostMapping(value = "/simian")
	public ResponseEntity<?> isSimian(@RequestBody DnaDTO dna) {
		
		if(!simianService.isSimian(dna)) {
			throw new UnsupportedDNAException();
		}
		
		return ResponseEntity.ok().build();		
	}
	

	@GetMapping(value = "/stats")
	public List<Population> findStatsDna() {
		return simianService.findStats();
	}

}
