package br.edu.unoescsmo.bootweb.regras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoescsmo.bootweb.model.Jogador;
import br.edu.unoescsmo.bootweb.repository.JogadorRepository;
@Service
public class JogadorPadrao implements JogadorRegra {

	@Autowired
	private JogadorRepository jogadorRepository;

	@Override
	public void salvar(Jogador jogador) {
		jogadorRepository.save(jogador);

	}

	@Override
	public void delete(Jogador jogador) {
		jogadorRepository.delete(jogador);
	}

	@Override
	public Jogador buscarJogador(Long codigo) {
		return jogadorRepository.findById(codigo).orElse(new Jogador());
	}

}
