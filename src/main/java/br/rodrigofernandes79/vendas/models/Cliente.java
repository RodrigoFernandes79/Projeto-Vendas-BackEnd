package br.rodrigofernandes79.vendas.models;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import antlr.collections.List;
import lombok.Data;


@Entity
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,length = 150)
	private String nome;
	@Column(nullable = false, length = 11)
	private String cpf;
	@Column(name="data_cadastro")
	private LocalDate dataCadastro;
	
	
	
	
	

	
	
}
		
