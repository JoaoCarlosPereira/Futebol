package br.edu.unoescsmo.bootweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.unoescsmo.bootweb.model.Time;

public interface TimeRepository extends JpaRepository<Time, Long> {
	@Query("select t from Time t")
	List<Time> dadosGrid();
		
}
