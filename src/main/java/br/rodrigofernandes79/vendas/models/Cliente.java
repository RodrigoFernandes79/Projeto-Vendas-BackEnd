package br.rodrigofernandes79.vendas.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Campo não informado!")
	@Column(nullable = false,length = 150)
	private String nome;
	@NotBlank(message="Campo não informado!")
	@CPF(message= "Campo inválido!Inserir um Cpf Válido!")
	@Column(nullable = false, length = 11)
	private String cpf;
	@Column(name="data_cadastro")
	@JsonFormat(pattern ="dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	
	@PrePersist
	public void inserirDataCadastro() {
		setDataCadastro(LocalDate.now());
	
	}

          
	
	
	

	
	
}
		
