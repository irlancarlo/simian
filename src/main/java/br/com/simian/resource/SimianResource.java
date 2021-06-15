package br.com.simian.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.simian.domain.Dna;
import br.com.simian.dto.DnaDTO;
import br.com.simian.service.SimianService;

@RestController
@RequestMapping("/simian")
public class SimianResource {

	@Autowired
	private SimianService simianService;

	@RequestMapping(value = "simian", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void isSimian(@RequestBody DnaDTO dna) {
		
		simianService.isSimian(dna);
		
	}
	

	@RequestMapping(value = "/stats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Dna findStatsDna() {
		return simianService.findStats();
	}

}
