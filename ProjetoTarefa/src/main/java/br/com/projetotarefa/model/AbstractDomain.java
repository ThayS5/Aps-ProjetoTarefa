package br.com.projetotarefa.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
@SuppressWarnings("serial")
public class AbstractDomain implements Serializable{
	
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
