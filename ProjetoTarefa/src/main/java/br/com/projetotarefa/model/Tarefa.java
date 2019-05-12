package br.com.projetotarefa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@SuppressWarnings("serial")
@Entity
public class Tarefa extends AbstractDomain{

	private String nome;
	private String descricao;
	private Date dataCriacao;
	private Date dataFechamento;
	private Date dataVencimento;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Situacao situacao;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Projeto projeto;
	
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
	@Temporal(TemporalType.DATE)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	@Temporal(TemporalType.DATE)
	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	@Temporal(TemporalType.DATE)
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	
	
}
