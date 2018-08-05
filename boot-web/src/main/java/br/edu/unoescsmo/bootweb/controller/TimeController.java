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

import br.edu.unoescsmo.bootweb.model.Time;
import br.edu.unoescsmo.bootweb.regras.TimeRegra;
import br.edu.unoescsmo.bootweb.repository.TimeRepository;

@Controller
@RequestMapping("/futebol")
public class TimeController {
	@Autowired
	private TimeRegra timeRegra;

	@Autowired
	private TimeRepository timeRepository;

	@GetMapping("/time")
	public String novo(Model model) {
		model.addAttribute("time", new Time());
		return "jogador/time";
	}

	@PostMapping("/time/salvar")
	public String salvar(@Valid Time time, BindingResult erros) {
		if (erros.hasErrors()) {
			return "jogador/time";
		}
		timeRegra.salvar(time);
		return "redirect:/futebol/time";
	}

	@GetMapping("/time/deletar/{codigo}")
	public String deletar(@PathVariable("codigo") Long codigo) {
		timeRegra.delete(new Time(codigo));
		return "redirect:/futebol/time";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("times", timeRepository.findAll());
		return "jogador/listar";
	}

	@GetMapping("/time/{codigo}")
	public String Editar(@PathVariable("codigo") Long codigo, Model model) {
		model.addAttribute("time", timeRegra.buscarTime(codigo));
		return "jogador/time";
	}

}
