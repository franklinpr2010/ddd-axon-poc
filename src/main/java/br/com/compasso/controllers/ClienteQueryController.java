/**
 * 
 */
package br.com.compasso.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.aggregates.ClienteAggregate;
import br.com.compasso.exceptions.EntityNotFoundException;
import br.com.compasso.repositories.ClienteRepository;

/**
 * Classes de controller ClienteController
 * @author franklin.roza
 *
 */
@RestController
public class ClienteQueryController {
	
	private final ClienteRepository repository;

	ClienteQueryController(ClienteRepository repository) {
	    this.repository = repository;
	}

}
