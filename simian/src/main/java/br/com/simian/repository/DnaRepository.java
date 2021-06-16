package br.com.simian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.simian.domain.Population;

@Repository
public interface DnaRepository extends JpaRepository<Population, Long> {

}
