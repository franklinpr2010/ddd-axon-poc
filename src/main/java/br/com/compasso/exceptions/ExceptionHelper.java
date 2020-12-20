package br.com.compasso.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {
	
	  @ExceptionHandler(value = { Exception.class })
	  public ResponseEntity<Object> handleException(Exception ex) {
	      return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  
	  @ExceptionHandler(value = { IllegalArgumentException.class })
	  public ResponseEntity<Object> handleException(IllegalArgumentException ex) {
	      return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	  }

}
