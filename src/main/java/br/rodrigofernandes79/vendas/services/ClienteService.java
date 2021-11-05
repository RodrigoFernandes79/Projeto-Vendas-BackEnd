package br.rodrigofernandes79.vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.rodrigofernandes79.vendas.models.Cliente;
import br.rodrigofernandes79.vendas.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	

	public Cliente criarCliente(Cliente cliente) {
		Cliente obj = repository.save(cliente);
		return obj;
	}



	

}
