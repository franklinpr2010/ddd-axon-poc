package br.com.compasso.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import br.com.compasso.entity.Cidade;
import br.com.compasso.enums.EstadoEnum;
import br.com.compasso.query.BuscarCidadePorEstadoQuery;
import br.com.compasso.query.BuscarCidadePorIdQuery;
import br.com.compasso.query.BuscarCidadePorNomeQuery;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class CidadeQueryService {

	private QueryGateway queryGateway;
    private EventStore eventStore;

	
    public CompletableFuture<Cidade> findById(UUID cidadeId) {
        return this.queryGateway.query(
                new BuscarCidadePorIdQuery(cidadeId),
                ResponseTypes.instanceOf(Cidade.class)
        );
    }
    
    public CompletableFuture<Cidade> findByNome(String nome) {
        return this.queryGateway.query(
                new BuscarCidadePorNomeQuery(nome),
                ResponseTypes.instanceOf(Cidade.class)
        );
    }
    
    public CompletableFuture<Cidade> findByEstado(EstadoEnum estado) {
        return this.queryGateway.query(
                new BuscarCidadePorEstadoQuery(estado),
                ResponseTypes.instanceOf(Cidade.class)
        );
    }

}
