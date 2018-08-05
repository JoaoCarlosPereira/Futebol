package br.edu.unoescsmo.bootweb.regras;

import br.edu.unoescsmo.bootweb.model.Jogador;

public interface JogadorRegra {
	void salvar(Jogador jogador);

	void delete(Jogador jogador);
	
	Jogador buscarJogador(Long codigo);
}
