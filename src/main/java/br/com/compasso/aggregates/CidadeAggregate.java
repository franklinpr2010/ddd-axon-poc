package br.com.compasso.aggregates;

import java.io.Serializable;
import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import br.com.compasso.commands.CriarCidadeCommand;
import br.com.compasso.enums.EstadoEnum;
import br.com.compasso.event.CidadeCriadoEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * AggregateRoot Cidade
 * 
 * @author franklin.roza
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class CidadeAggregate implements Serializable{

	private static final long serialVersionUID = -8215397219603180720L;

	@AggregateIdentifier
    private UUID id;
	
	private String nome;
	
	private EstadoEnum estado;
	

	@CommandHandler
	public CidadeAggregate(CriarCidadeCommand command) {
		 AggregateLifecycle.apply(
		            new CidadeCriadoEvent(
		                    command.getId(),
		                    command.getNome(),
		                    command.getEstado()
		            )
		    );
	}
	
	@EventSourcingHandler
	public void on(CidadeCriadoEvent event) {
		this.id = event.getId();
		this.nome = event.getNome();
		this.estado = event.getEstado();
	}
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

    
}
