package br.com.compasso.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import br.com.compasso.entity.Cliente;
import br.com.compasso.query.BuscarCidadePorNomeQuery;
import br.com.compasso.query.BuscarClientePorIdQuery;

@Service
public class ClienteQueryService {
	
	private QueryGateway queryGateway;
    private EventStore eventStore;

	public ClienteQueryService(QueryGateway queryGateway, EventStore eventStore) {
		this.queryGateway = queryGateway;
		this.eventStore = eventStore;
	}
	
    public CompletableFuture<Cliente> findById(UUID clienteId) {
        return this.queryGateway.query(
                new BuscarClientePorIdQuery(clienteId),
                ResponseTypes.instanceOf(Cliente.class)
        );
    }
    
    public CompletableFuture<Cliente> findByNome(String nome) {
        return this.queryGateway.query(
                new BuscarCidadePorNomeQuery(nome),
                ResponseTypes.instanceOf(Cliente.class)
        );
    }
    
    
}
