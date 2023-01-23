package com.attornatus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attornatus.model.Pessoa;
import com.attornatus.repository.PessoaRepository;

@Service
public class ListarPessoasServiceImp {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}
}
