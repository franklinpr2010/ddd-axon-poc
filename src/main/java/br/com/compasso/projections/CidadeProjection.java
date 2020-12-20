package br.com.compasso.projections;

import java.util.Optional;

import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.queryhandling.QueryHandler;

import br.com.compasso.entity.Cidade;
import br.com.compasso.event.CidadeCriadoEvent;
import br.com.compasso.exceptions.DuplicationAttributeException;
import br.com.compasso.exceptions.EntityNotFoundException;
import br.com.compasso.query.BuscarCidadePorEstadoQuery;
import br.com.compasso.query.BuscarCidadePorNomeQuery;
import br.com.compasso.repositories.CidadeRepository;

public class CidadeProjection {

	private CidadeRepository repository;
	
	public CidadeProjection(CidadeRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * Cadastrar cidade
	 * @param event
	 */
	@EventSourcingHandler
	public void on(CidadeCriadoEvent event) throws DuplicationAttributeException {
		Cidade cidade = new Cidade(event.getId(),
		event.getNome(),
		event.getEstado());
		Optional<Cidade> cid = repository.findByNomeAllIgnoreCase(event.getNome());
		if(cid.isPresent()) {
			throw new DuplicationAttributeException("nome", event.getNome());
		}
		this.repository.save(cidade);
	}
	
	/**
	 * Consultar cidade pelo nome
	 * @param query
	 * @return
	 */
	@QueryHandler
	public Cidade handle(BuscarCidadePorNomeQuery query) throws EntityNotFoundException {
	   Optional<Cidade> cidade = this.repository.findByNomeAllIgnoreCase(query.getNome());
	   if(cidade.isPresent()) {
		   return cidade.get();
	   } else {
		   throw new EntityNotFoundException("nome", query.getNome());
	   }
	}
	
	/**
	 * Consultar cidade pelo estado
	 * @param query
	 * @return
	 */
	@QueryHandler
	public Cidade handle(BuscarCidadePorEstadoQuery query) throws EntityNotFoundException {
		Optional<Cidade> cidade = this.repository.findByEstado(query.getEstadoEnum());
		if(cidade.isPresent()) {
		   return cidade.get();
	   } else {
		   throw new EntityNotFoundException("estado", query.getEstadoEnum().getNome());
	   }
	}
}