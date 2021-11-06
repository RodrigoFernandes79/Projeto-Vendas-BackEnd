package br.rodrigofernandes79.vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rodrigofernandes79.vendas.models.Cliente;
import br.rodrigofernandes79.vendas.services.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente){
		Cliente obj = service.criarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(obj);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>>listarCliente(){
		List<Cliente> obj = service.listarCliente();
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
		Cliente obj = service.listarPorId(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
