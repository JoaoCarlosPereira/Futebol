package br.edu.unoescsmo.bootweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoescsmo.bootweb.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

	@Query("select j from Jogador j inner join Escalacao p on j.codigo = p.jogador where p.time = :time")
	List<Jogador> listarEscalacao(@Param("time") Long time);
}
