package br.rodrigofernandes79.vendas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.rodrigofernandes79.vendas.models.Cliente;
import br.rodrigofernandes79.vendas.services.ClienteService;



@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping
	public ResponseEntity<Cliente> criarCliente(@Valid @RequestBody Cliente cliente){
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
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id){
			service.deletar(id);
	
	}
	
	@PutMapping("/{id}")
	
	public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id,@RequestBody @Valid Cliente cliente ){
		Cliente obj = service.atualizarCliente(id,cliente);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(obj);
		
	}
	
	
}
