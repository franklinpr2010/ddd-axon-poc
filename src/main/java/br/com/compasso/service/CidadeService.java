package br.com.compasso.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import br.com.compasso.commands.CriarCidadeCommand;
import br.com.compasso.entity.Cidade;
import br.com.compasso.viewmodel.CidadeViewModel;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CidadeService {
	
	private CommandGateway commandGateway;

	
	public CompletableFuture<Cidade> criar(CidadeViewModel cidadeViewModel) {
        return this.commandGateway.send(new CriarCidadeCommand(
                UUID.randomUUID(),
                cidadeViewModel.getNome(),
                cidadeViewModel.getEstado()
        ));
    }

}
