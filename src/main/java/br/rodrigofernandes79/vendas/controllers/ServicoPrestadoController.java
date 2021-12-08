package br.rodrigofernandes79.vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rodrigofernandes79.vendas.models.ServicoPrestado;
import br.rodrigofernandes79.vendas.services.ServicoPrestadoService;

@RestController
@RequestMapping("/serviços")
public class ServicoPrestadoController {
	
	@Autowired
	public ServicoPrestadoService service;
	
	@PostMapping
	public ResponseEntity<ServicoPrestado> criarServico(@RequestBody ServicoPrestado servico){
		return ResponseEntity.status(HttpStatus.OK).body(service.criarServico());
		
	}
	
	

}
