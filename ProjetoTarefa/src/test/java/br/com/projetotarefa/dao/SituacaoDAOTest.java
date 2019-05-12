package br.com.projetotarefa.dao;

import org.junit.Test;

import br.com.projetotarefa.model.Situacao;

public class SituacaoDAOTest {

	@Test
	public void salvar() {
		
		Situacao situacao = new Situacao();
		situacao.setDescricao("Em andamento");
	
		SituacaoDAO situacaoDAO = new SituacaoDAO();
		situacaoDAO.salvar(situacao);
	}
}
