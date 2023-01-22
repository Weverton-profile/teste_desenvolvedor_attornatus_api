package com.attornatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.datasource.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	Pessoa findByNome(String nome);
}
