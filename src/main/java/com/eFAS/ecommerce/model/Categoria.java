package com.eFAS.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.eFAS.ecommerce.model.Produto;

public class Categoria {
	@Id @NotNull @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@NotNull @Size(min=2, max=100)
	private String nome;
	
	@NotNull
	private boolean organico;
	
	@NotNull
	private boolean industrial;
	
	@OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isOrganico() {
		return organico;
	}

	public void setOrganico(boolean organico) {
		this.organico = organico;
	}

	public boolean isIndustrial() {
		return industrial;
	}

	public void setIndustrial(boolean industrial) {
		this.industrial = industrial;
	}

	public List<Produto> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Produto> postagem) {
		this.postagem = postagem;
	}
	
}
