package br.com.simian.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DnaDTO {

    private List<String> dna = new ArrayList<String>();

}
