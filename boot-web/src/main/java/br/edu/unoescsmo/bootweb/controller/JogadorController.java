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

import br.edu.unoescsmo.bootweb.model.Jogador;
import br.edu.unoescsmo.bootweb.regras.JogadorRegra;

@Controller
@RequestMapping("/futebol")
public class JogadorController {

	@Autowired
	private JogadorRegra jogadorRegra;

	@PostMapping("/jogador/salvar")
	public String salvar(@Valid Jogador jogador, BindingResult erros) {
		if (erros.hasErrors()) {
			return "jogador/novo";
		}
		jogadorRegra.salvar(jogador);
		return "redirect:/futebol/jogador";
	}

	@GetMapping("/jogador")
	public String novo(Model model) {
		model.addAttribute("jogador", new Jogador());
		return "jogador/jogador";
	}

	@GetMapping("/jogador/deletar/{codigo}")
	public String deletar(@PathVariable("codigo") Long codigo) {
		jogadorRegra.delete(new Jogador(codigo));
		return "redirect:/futebol/jogador";
	}
	
	@GetMapping("/jogador/{codigo}")
	public String editar(@PathVariable("codigo") Long codigo, Model model) {
		model.addAttribute("jogador", jogadorRegra.buscarJogador(codigo));
		return "jogador/jogador";
	}	
}
