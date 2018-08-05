package br.edu.unoescsmo.bootweb.regras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoescsmo.bootweb.model.Time;
import br.edu.unoescsmo.bootweb.repository.TimeRepository;
@Service
public class TimePadrao implements TimeRegra {

	@Autowired
	private TimeRepository timeRepository;

	@Override
	public void salvar(Time time) {
		timeRepository.save(time);

	}

	@Override
	public void delete(Time time) {
		timeRepository.delete(time);

	}

	@Override
	public Time buscarTime(Long codigo) {
		return timeRepository.findById(codigo).orElse(new Time());
	}

}
