package br.com.projetotarefa.dao;

import java.util.List;

 
import org.junit.Ignore;
import org.junit.Test;

import br.com.projetotarefa.model.Projeto;
 

public class ProjetoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		Projeto projeto  = new Projeto();
		
		projeto.setNome("APS");
		projeto.setDescricao("Desenvolvimento de Aplicações Corporativas");
	
		ProjetoDAO projetoDAO = new ProjetoDAO();
		projetoDAO.salvar(projeto);
	}
	@Test
	@Ignore
	public void listar() {
		ProjetoDAO projetoDAO = new ProjetoDAO();
		List<Projeto> resultado = projetoDAO.listar();
		
		for(Projeto projeto : resultado) {
			System.out.println("ID: " + projeto.getId());
			System.out.println("Nome: " + projeto.getNome());
			System.out.println("Descrição: " + projeto.getDescricao());
		}
		
		
	}
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 11L;
		ProjetoDAO projetoDAO = new ProjetoDAO();
		Projeto projeto  = projetoDAO.buscar(codigo);
			
		System.out.println("ID: " + projeto.getId());	
		
		
	}
	@Test
	@Ignore
	public void excluir() {
		
		Long codigo = 8L;
		ProjetoDAO projetoDAO = new ProjetoDAO();
		Projeto projeto  = projetoDAO.buscar(codigo);
		
		projetoDAO.excluir(projeto);
		
	}
	@Test
	public void editar() {
		 
			Long codigo = 5L;
			ProjetoDAO projetoDAO = new ProjetoDAO();
			Projeto projeto  = projetoDAO.buscar(codigo);
			
			projeto.setDescricao("Desc. EDITADA");
			projetoDAO.editar(projeto);
	}
}
