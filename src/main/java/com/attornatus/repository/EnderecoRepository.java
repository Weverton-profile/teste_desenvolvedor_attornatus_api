package com.attornatus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>  {
}
