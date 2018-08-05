package br.edu.unoescsmo.bootweb.regras;


import br.edu.unoescsmo.bootweb.model.Escalacao;

public interface EscalacaoRegra {
	void salvar(Escalacao confronto);

	void delete(Escalacao confronto);
}
