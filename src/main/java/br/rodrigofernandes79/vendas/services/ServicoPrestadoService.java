package br.rodrigofernandes79.vendas.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.rodrigofernandes79.vendas.models.ServicoPrestado;
import br.rodrigofernandes79.vendas.repositories.ServicoPrestadoRepository;

public class ServicoPrestadoService {
	
	@Autowired
	private ServicoPrestadoRepository repository;

	public Object criarServico(ServicoPrestado servico) {
		ServicoPrestado obj = repository.save(servico);
		return obj;
	}

}
