package com.attornatus.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String data_nascimento;
	@Column(nullable = true)
	@OneToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
	private List<Endereco> enderecos;
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
}
