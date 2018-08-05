package br.edu.unoescsmo.bootweb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoescsmo.bootweb.model.Escalacao;

public interface EscalacaoRepository extends JpaRepository<Escalacao, Long> {
	@Query("select e from Escalacao e where e.jogador = :jogador")
	Escalacao EscalacaoPorJogador(@Param("jogador") Long jogador);
}
