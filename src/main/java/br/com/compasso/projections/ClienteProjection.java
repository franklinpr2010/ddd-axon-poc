package br.com.compasso.projections;

import java.util.Optional;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import br.com.compasso.entity.Cliente;
import br.com.compasso.event.ClienteAtualizadoEvent;
import br.com.compasso.event.ClienteCriadoEvent;
import br.com.compasso.event.ClienteRemovidoEvent;
import br.com.compasso.exceptions.DuplicationAttributeException;
import br.com.compasso.query.BuscarClientePorIdQuery;
import br.com.compasso.query.BuscarClientePorNomeQuery;
import br.com.compasso.repositories.ClienteRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ClienteProjection {
	private  ClienteRepository repository;
	
	
	/**
	 * Cadastrar cliente
	 * @param event
	 */
	@EventSourcingHandler
	public void on(ClienteCriadoEvent event) {
		Cliente cliente = new Cliente(event.getId(),
		event.getNomeCompleto(),
		event.getSexo(),
		event.getDataNascimento(),
		event.getCidade(), null);
		//Verificando se já existe esse cliente
		Optional<Cliente> cid = repository.findByNomeCompletoAllIgnoreCase(event.getNomeCompleto());
		if(cid.isPresent()) {
			throw new DuplicationAttributeException("Nome Completo", event.getNomeCompleto());
		}
		this.repository.save(cliente);
	}
	
	/**
	 * Alterar o nome do cliente
	 * @param event
	 */
	@EventSourcingHandler
	public void on(ClienteAtualizadoEvent event) {
		Cliente cli = this.repository.findById(event.getIdAtual()).get();

		//Verificando se já existe esse cliente
		Optional<Cliente> cid = repository.findByNomeCompletoAllIgnoreCase(event.getNomeCompleto());
		if(cid.isPresent()) {
			if(!event.getId().equals(cid.get().getId())) {
				throw new DuplicationAttributeException("Nome Completo", event.getNomeCompleto());
			}
		}
		cli.atualizar(event.getNomeCompleto(), event.getSexo(), event.getDataNascimento(), event.getCidade());
		this.repository.save(cli);
	}
	
	/**
	 * Remover cliente
	 * @param event
	 */
	@EventSourcingHandler
	public void on(ClienteRemovidoEvent event) {
		//Verificando se já existe esse cliente
		Optional<Cliente> cid = repository.findById(event.getId());
		this.repository.delete(cid.get());
	}
	
	/**
	 * Consultar cliente pelo Id
	 * @param query
	 * @return
	 */
	@QueryHandler
	public Cliente handle(BuscarClientePorIdQuery query) {
	    return this.repository.findById(query.getClienteId()).orElse(null);
	}
	
	
	/**
	 * Consultar cliente pelo Nome
	 * @param query
	 * @return
	 */
	@QueryHandler
	public Cliente handle(BuscarClientePorNomeQuery query) {
	    return this.repository.findByNomeCompletoAllIgnoreCase(query.getNome()).orElse(null);
	}

}
