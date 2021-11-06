package br.rodrigofernandes79.vendas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.rodrigofernandes79.vendas.models.Cliente;
import br.rodrigofernandes79.vendas.repositories.ClienteRepository;




@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	

	public Cliente criarCliente( Cliente cliente) {
		Cliente obj = repository.save(cliente);
		return obj;
	}



	public List<Cliente> listarCliente() {
		List<Cliente> obj = repository.findAll();
		return obj;
	}



	public Cliente listarPorId(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}



	public void deletar(Long id){
		repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Id: "
				+id+ " não foi encontrado."));
		repository.deleteById(id);
	}



	public Cliente atualizarCliente(Long id, Cliente cliente) {
		  return repository.findById(id)
				.map(record ->{
				record.setNome(cliente.getNome());
				record.setCpf(cliente.getCpf());
				Cliente obj =repository.save(record);
				
				return obj;
				})
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Id "+id+ " não foi encontrado.")); 
		
	}



	

}
