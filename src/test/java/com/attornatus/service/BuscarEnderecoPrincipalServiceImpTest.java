package com.attornatus.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.attornatus.model.Endereco;

@SpringBootTest
@WebAppConfiguration
public class BuscarEnderecoPrincipalServiceImpTest {
	
	@Autowired
	private BuscarEnderecoPrincipalServiceImp serviceImp;
	
	@Test
	public void buscarEnderecoPrincipalTest() {
		Endereco endereco = (Endereco) serviceImp.buscarEnderecoPrincipal("Werverton");
		assertEquals("rua narnia", endereco.getLogradouro());
		assertEquals("64054-780", endereco.getCep());
		assertEquals(Long.parseLong("3225"), endereco.getNumero());
		assertEquals("Cronicas", endereco.getCidade());
		assertEquals(true, endereco.getPrincipal());
	}
}
