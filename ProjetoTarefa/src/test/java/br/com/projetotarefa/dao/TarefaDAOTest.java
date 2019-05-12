package br.com.projetotarefa.dao;

 

import org.junit.Test;

import br.com.projetotarefa.model.Projeto;
import br.com.projetotarefa.model.Situacao;
import br.com.projetotarefa.model.Tarefa;

public class TarefaDAOTest {

	@Test
	public void salvar() {
		
				 
		ProjetoDAO projetoDAO = new ProjetoDAO();
		Projeto projeto = projetoDAO.buscar(5L);
		 
		SituacaoDAO situaoDao = new SituacaoDAO();
		Situacao situacao = situaoDao.buscar(10L);
		
		Tarefa tarefa = new Tarefa();
		 
		tarefa.setNome("Criar Projeto");
		 
		tarefa.setProjeto(projeto);
		tarefa.setSituacao(situacao);	
		
		TarefaDAO tarefaDAO = new TarefaDAO();
		tarefaDAO.salvar(tarefa);
		
	}
}
