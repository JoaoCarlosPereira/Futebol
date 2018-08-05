package br.edu.unoescsmo.bootweb.regras;

import br.edu.unoescsmo.bootweb.model.Time;

public interface TimeRegra {
	void salvar(Time time);

	void delete(Time time);
	
	Time buscarTime(Long codigo);
}
