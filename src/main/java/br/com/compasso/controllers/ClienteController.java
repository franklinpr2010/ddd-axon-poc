/**
 * 
 */
package br.com.compasso.controllers;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.entity.Cliente;
import br.com.compasso.service.ClienteService;
import br.com.compasso.viewmodel.ClienteViewModel;
import io.swagger.annotations.Api;

/**
 * Classes de controller ClienteController
 * @author franklin.roza
 *
 */
@RestController
@Api(value = "Api da cliente", description = "Api da cliente")
public class ClienteController {
	
	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
	    this.clienteService = clienteService;
	}
	
	/**
	 * Metodo que vai salvar o cliente
	 * @param clienteViewModel
	 * @return
	 */
    @PostMapping("/cliente")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CompletableFuture<Cliente> criarCliente(@RequestBody ClienteViewModel clienteViewModel) {
        return this.clienteService.criar(clienteViewModel);
    }
    
    
    /**
	 * Metodo que vai atualizar o cliente
	 * @param clienteViewModel
	 * @return
	 */
    @PutMapping(value = "/cliente/{clienteId}")
    public CompletableFuture<Cliente> criarCidade(@PathVariable(value = "clienteId") UUID clienteId,
                                                          @RequestBody ClienteViewModel clienteViewModel) {
        return this.clienteService.atualizar(clienteId, clienteViewModel);
    }
    
    
    /**
  	 * Metodo que vai remover o cliente
  	 * @param clienteViewModel
  	 * @return
  	 */
    @DeleteMapping(value = "/cidade/{cidadeId}")
    public CompletableFuture<Cliente> removerCidade(@RequestBody ClienteViewModel clienteViewModel) {
        return this.clienteService.remover(clienteViewModel);
    }
}
