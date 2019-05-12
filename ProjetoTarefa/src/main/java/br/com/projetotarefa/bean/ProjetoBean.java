package br.com.projetotarefa.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.projetotarefa.dao.ProjetoDAO;

import br.com.projetotarefa.model.Projeto;

@SuppressWarnings("serial") 
@ManagedBean
@ViewScoped
public class ProjetoBean implements Serializable {
	private Projeto projeto;
	private List<Projeto> projetos;

	public void novo() {
		projeto = new Projeto();
	}

	public void salvar() {
		try {
			ProjetoDAO projetoDAO = new ProjetoDAO();
			
			projetoDAO.merge(projeto);

			projeto = new Projeto();
			projetos = projetoDAO.listar();

			Messages.addFlashGlobalInfo("Projeto salvo com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar a Situação.");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {

		try {

			projeto = (Projeto) evento.getComponent().getAttributes().get("projetoSelecionado");

			ProjetoDAO projetoDAO = new ProjetoDAO();
			projetoDAO.excluir(projeto);

			projetos = projetoDAO.listar();

			Messages.addFlashGlobalInfo("Projeto excluído com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluír o Projeto");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {

			projeto = (Projeto) evento.getComponent().getAttributes().get("projetoSelecionado");

			ProjetoDAO projetoDAO = new ProjetoDAO();
			projetoDAO.merge(projeto);

			projetos = projetoDAO.listar();

		
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar o Projeto");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			ProjetoDAO projetoDAO = new ProjetoDAO();
			projetos = projetoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os Projetos");
			erro.printStackTrace();
		}
	}

	


	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
}
