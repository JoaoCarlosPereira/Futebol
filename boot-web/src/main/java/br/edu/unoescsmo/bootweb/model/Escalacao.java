package br.edu.unoescsmo.bootweb.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Escalacao {

	public Escalacao() {
	}

	public Escalacao(Long codigo) {
		this.codigo = codigo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	@Column(nullable = false)
	private Long time;

	@Column(nullable = false)
	private Long jogador;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Long getJogador() {
		return jogador;
	}

	public void setJogador(Long jogador) {
		this.jogador = jogador;
	}
}
