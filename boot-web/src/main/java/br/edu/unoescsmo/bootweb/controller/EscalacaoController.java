package br.edu.unoescsmo.bootweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoescsmo.bootweb.model.Escalacao;
import br.edu.unoescsmo.bootweb.regras.EscalacaoRegra;
import br.edu.unoescsmo.bootweb.repository.EscalacaoRepository;
import br.edu.unoescsmo.bootweb.repository.JogadorRepository;
import br.edu.unoescsmo.bootweb.repository.TimeRepository;

@Controller
@RequestMapping("/futebol")
public class EscalacaoController {
	@Autowired
	private EscalacaoRegra escalacaoRegra;

	@Autowired
	private EscalacaoRepository escalacaoRepository;

	@Autowired
	private JogadorRepository jogadorRepository;

	@Autowired
	private TimeRepository timeRepository;

	@GetMapping("/escalacao")
	public String novo(Model model) {
		model.addAttribute("jogadores", jogadorRepository.findAll());
		model.addAttribute("times", timeRepository.findAll());
		return "jogador/escalacao";
	}

	@PostMapping("/escalacao/salvar")
	public String salvar(@Valid Escalacao escalacao, BindingResult erros) {
		if (erros.hasErrors()) {
			return "jogador/escalacao";
		}
		escalacaoRegra.salvar(escalacao);
		return "redirect:/futebol/escalacao";
	}

	@GetMapping("/escalacao/deletar/{codigo}")
	public String deletar(@PathVariable("codigo") Long jogador) {		
		escalacaoRegra.delete(escalacaoRepository.EscalacaoPorJogador(jogador));
		return "jogador/listarescalacao";
	}
	
	@GetMapping("/escalacao/{codigo}")
	public String visualizar(@PathVariable("codigo") Long time, Model model) {
		model.addAttribute("jogadores", jogadorRepository.listarEscalacao(time));
		return "jogador/listarescalacao";
	}	
}
