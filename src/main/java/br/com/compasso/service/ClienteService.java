package br.com.compasso.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import br.com.compasso.commands.AtualizarClienteCommand;
import br.com.compasso.commands.CriarClienteCommand;
import br.com.compasso.commands.RemoverClienteCommand;
import br.com.compasso.entity.Cliente;
import br.com.compasso.viewmodel.ClienteViewModel;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {
	private CommandGateway commandGateway;
	
	/**
	 * Metodo que vai criar um Cliente
	 * @param clienteViewModel
	 * @return CompletableFuture<Cliente>
	 */
	public CompletableFuture<Cliente> criar(ClienteViewModel clienteViewModel) {
        return this.commandGateway.sendAndWait(new CriarClienteCommand(
        		UUID.randomUUID(),
                clienteViewModel.getNomeCompleto(),
                clienteViewModel.getSexo(),
                clienteViewModel.getDataNascimento(),
                clienteViewModel.getCidade(), null
        ));
    }
	
	/**
	 * Metodo que vai atualizar um Cliente
	 * @param clienteViewModel
	 * @return CompletableFuture<Cliente>
	 */
	public CompletableFuture<Cliente> atualizar(UUID clienteID,  ClienteViewModel clienteViewModel) {
        return this.commandGateway.send(new AtualizarClienteCommand(
        		UUID.randomUUID(),
                clienteViewModel.getNomeCompleto(),
                clienteViewModel.getSexo(),
                clienteViewModel.getDataNascimento(),
                clienteViewModel.getCidade(), null, clienteID
        ));
    }
	
	/**
	 * Metodo que vai remover um Cliente
	 * @param clienteViewModel
	 * @return CompletableFuture<Cliente>
	 */
	public CompletableFuture<Cliente> remover(ClienteViewModel clienteViewModel) {
        return this.commandGateway.send(new RemoverClienteCommand(
        		clienteViewModel.getId()
        ));
    }

}
