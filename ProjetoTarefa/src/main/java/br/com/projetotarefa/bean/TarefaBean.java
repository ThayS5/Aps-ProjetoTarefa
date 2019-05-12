package br.com.projetotarefa.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.projetotarefa.dao.ProjetoDAO;
import br.com.projetotarefa.dao.SituacaoDAO;
import br.com.projetotarefa.dao.TarefaDAO;
import br.com.projetotarefa.model.Projeto;
import br.com.projetotarefa.model.Situacao;
import br.com.projetotarefa.model.Tarefa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TarefaBean implements Serializable {
	private Tarefa tarefa;
	private List<Tarefa> tarefas;
	private List<Projeto> projetos;
	private List<Situacao> situacoes;
	
	public void novo() {
		tarefa = new Tarefa();
		
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetos = projetoDAO.listarOrdenado("nome"); 
		
		SituacaoDAO situacaoDAO = new SituacaoDAO();
		situacoes = situacaoDAO.listar();
		
	}

	public void salvar() {
		try {
			TarefaDAO tarefaDAO = new TarefaDAO();
		
			tarefa.setDataCriacao(new Date());
			tarefa.setDataVencimento(new Date());
			
			if(tarefa.getSituacao().getDescricao() !="Fechada") {
				tarefa.setDataFechamento(null);
			}else {
				tarefa.setDataFechamento(new Date());
			}			 
			
			tarefaDAO.merge(tarefa);

			tarefa = new Tarefa();
			
			ProjetoDAO projetoDAO = new ProjetoDAO();
			projetos = projetoDAO.listarOrdenado("nome");
			
			SituacaoDAO situacaoDAO = new SituacaoDAO();
			situacoes = situacaoDAO.listar();
			
			tarefas = tarefaDAO.listar();
			
			  
			 
			Messages.addFlashGlobalInfo("Tarefa salva com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar a Tarefa.");
			erro.printStackTrace();
		}
	}
 
	public void excluir(ActionEvent evento) {

		try {

			tarefa = (Tarefa) evento.getComponent().getAttributes().get("tarefaSelecionada");

			TarefaDAO tarefaDAO = new TarefaDAO();
			tarefaDAO.excluir(tarefa);

			
			tarefas = tarefaDAO.listar();

			Messages.addFlashGlobalInfo("Tarefa excluída com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluír a Tarefa");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {

			tarefa = (Tarefa) evento.getComponent().getAttributes().get("tarefaSelecionada");

			TarefaDAO tarefaDAO = new TarefaDAO();
			tarefaDAO.merge(tarefa);

			tarefas = tarefaDAO.listar();

			 
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar a Tarefa");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			TarefaDAO tarefaDAO = new TarefaDAO();
			tarefas = tarefaDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as Tarefas");
			erro.printStackTrace();
		}
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<Situacao> getSituacoes() {
		return situacoes;
	}

	public void setSituacoes(List<Situacao> situacoes) {
		this.situacoes = situacoes;
	}

	
	
}
