package com.attornatus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Endereco {
	
	@Id
	@ManyToOne
	private Pessoa pessoa;
	private String logradouro;
	private String cep;
	private Long numero;
	private String cidade;
	@Column(nullable = true)
	private Boolean principal;
	
	public String getLogradouro() {
		return logradouro;
	}
	public String getCep() {
		return cep;
	}
	public Long getNumero() {
		return numero;
	}
	public String getCidade() {
		return cidade;
	}
	public Boolean getPrincipal() {
		return principal;
	}

}
