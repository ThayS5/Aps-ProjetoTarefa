package br.com.projetotarefa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.projetotarefa.dao.SituacaoDAO;
import br.com.projetotarefa.model.Situacao;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class SituacaoBean implements Serializable {
	private Situacao situacao;
	private List<Situacao> situacoes;

	public void novo() {
		situacao = new Situacao();
	}

	public void salvar() {
		try {
			SituacaoDAO situacaoDAO = new SituacaoDAO();
			situacaoDAO.merge(situacao);

			situacao = new Situacao();
			situacoes = situacaoDAO.listar();

			Messages.addFlashGlobalInfo("Situação salva com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar a Situação.");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {

		try {

			situacao = (Situacao) evento.getComponent().getAttributes().get("situacaoSelecionada");

			SituacaoDAO situacaoDAO = new SituacaoDAO();
			situacaoDAO.excluir(situacao);

			situacoes = situacaoDAO.listar();

			Messages.addFlashGlobalInfo("Situação excluída com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluída a Situação");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {

			situacao = (Situacao) evento.getComponent().getAttributes().get("situacaoSelecionada");

			SituacaoDAO situacaoDAO = new SituacaoDAO();
			situacaoDAO.merge(situacao);

			situacoes = situacaoDAO.listar();

			//Messages.addFlashGlobalInfo("Situação editada com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar a Situação");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			SituacaoDAO situacaoDAO = new SituacaoDAO();
			situacoes = situacaoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Situações");
			erro.printStackTrace();
		}
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public List<Situacao> getSituacoes() {
		return situacoes;
	}

	public void setSituacoes(List<Situacao> situacoes) {
		this.situacoes = situacoes;
	}

}
