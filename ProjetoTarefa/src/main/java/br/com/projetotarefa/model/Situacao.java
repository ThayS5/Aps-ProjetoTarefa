package br.com.projetotarefa.model;

import javax.persistence.Column;
import javax.persistence.Entity;


@SuppressWarnings("serial")
@Entity

public class Situacao extends AbstractDomain{
	
	private String descricao;
	
	@Column(length = 60, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
