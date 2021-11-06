package br.rodrigofernandes79.vendas.controllers.validations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	//Interceptar mensagens de validação:
		@ResponseStatus(HttpStatus.BAD_REQUEST)  // informa que teremos um bad Request toda vez que
		@ExceptionHandler(MethodArgumentNotValidException.class) // a exceção for Method Argument Not Valid Exception
		public Map<String,String> HandleValidationException(MethodArgumentNotValidException ex){
			Map<String,String> errors = new HashMap<>();
			
			ex.getBindingResult().getAllErrors().forEach((record) ->{
				//pegando o nome do campo e da mensagem de erro:
				String fieldName = ((FieldError) record).getField();
				String errorMessage = record.getDefaultMessage();
				
				//E vou adicionar o nome do campo e da mensagem de erro na lista:
				errors.put(fieldName, errorMessage);
			
		});	
			return errors;

	}
}
