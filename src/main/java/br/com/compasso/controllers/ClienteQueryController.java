/**
 * 
 */
package br.com.compasso.controllers;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.entity.Cidade;
import br.com.compasso.entity.Cliente;
import br.com.compasso.repositories.ClienteRepository;
import br.com.compasso.service.CidadeQueryService;
import br.com.compasso.service.ClienteQueryService;

/**
 * Classes de controller ClienteController
 * @author franklin.roza
 *
 */
@RestController
public class ClienteQueryController {
	
	private ClienteQueryService clienteService;

	ClienteQueryController(ClienteQueryService clienteService) {
	    this.clienteService = clienteService;
	}
	
	
	@GetMapping("cliente/nome/{nome}")
    public CompletableFuture<Cliente> findByNome(@PathVariable("nome") String nome) {
        return this.clienteService.findByNome(nome);
    }
	
	@GetMapping("cliente/{id}")
    public CompletableFuture<Cliente> findById(@PathVariable("id") String id) {
        return this.clienteService.findById(UUID.fromString(id));
    }

}
