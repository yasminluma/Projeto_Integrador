package com.eFAS.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="usuario")
public class Usuario {
	
	@Id @NotNull @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@NotNull @Size(min=2, max=100)
	private String nome;
	
	@NotNull @Size(min=2, max=100)
	private String email;
	
	@NotNull @Size(min=2, max=100)
	private String senha;
	
	private long celular;

	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produtos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("destinatario")
	private List<Mensagem> mensagemRecebida;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("remetente")
	private List<Mensagem> mensagemEnviada;

	public long getId() {
		return id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Mensagem> getMensagemRecebida() {
		return mensagemRecebida;
	}

	public void setMensagemRecebida(List<Mensagem> mensagemRecebida) {
		this.mensagemRecebida = mensagemRecebida;
	}

	public List<Mensagem> getMensagemEnviada() {
		return mensagemEnviada;
	}

	public void setMensagemEnviada(List<Mensagem> mensagemEnviada) {
		this.mensagemEnviada = mensagemEnviada;
	}
	
	public long getCelular() {
		return celular;
	}

	public void setCelular(long celular) {
		this.celular = celular;
	}

}