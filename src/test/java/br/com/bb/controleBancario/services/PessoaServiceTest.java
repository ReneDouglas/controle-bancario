package br.com.bb.controleBancario.services;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.bb.controleBancario.dto.PessoaFisicaDTO;
import br.com.bb.controleBancario.pojo.PessoaFisica;
import br.com.bb.controleBancario.repositories.PessoaRepository;

public class PessoaServiceTest {
	
	private PessoaRepository repository;
	
	@Test
	public void testListarPessoasFisicas() {
		
		try {
			repository = new PessoaRepository();
			ArrayList<PessoaFisica> lista = repository.listarPessoasFisicas();
			
			if (lista == null || lista.isEmpty()) {
				throw new Exception("lista de pessoas físicas vazia.");
			}
			Assertions.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assertions.fail();
		}
		
		
	}

}
