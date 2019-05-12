package br.com.projetotarefa.model;

import javax.persistence.Column;
import javax.persistence.Entity;


@SuppressWarnings("serial")
@Entity
public class Projeto extends AbstractDomain {

	private String nome;
	private String descricao;

	@Column(length = 60, nullable = false)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(length = 200, nullable = false)
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
