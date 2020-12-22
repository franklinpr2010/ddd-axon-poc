package br.com.compasso.aggregates;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import br.com.compasso.commands.AtualizarClienteCommand;
import br.com.compasso.commands.CriarClienteCommand;
import br.com.compasso.commands.RemoverClienteCommand;
import br.com.compasso.entity.Cidade;
import br.com.compasso.enums.SexoEnum;
import br.com.compasso.event.ClienteAtualizadoEvent;
import br.com.compasso.event.ClienteCriadoEvent;
import br.com.compasso.event.ClienteRemovidoEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * AggregateRoot Cliente
 * @author franklin.roza
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class ClienteAggregate implements Serializable{

	private static final long serialVersionUID = 4653335586691363469L;
	
	
	@AggregateIdentifier
	private UUID id;

	private String nomeCompleto;

	private SexoEnum sexo;

	private Date dataNascimento;

	private Cidade cidade;
	
	private Integer idade;

	@CommandHandler
	public ClienteAggregate(CriarClienteCommand command) {
		 AggregateLifecycle.apply(
		            new ClienteCriadoEvent(
		                    command.getId(),
		                    command.getNomeCompleto(),
		                    command.getSexo(),
		                    command.getDataNascimento(),
		                    command.getCidade(),
		                    null
		            )
		    );
	}
	
	@EventSourcingHandler
	public void on(ClienteCriadoEvent event) {
		this.setId(event.getId());
		this.nomeCompleto = event.getNomeCompleto();
		this.sexo = event.getSexo();
		this.dataNascimento = event.getDataNascimento();
		this.cidade = event.getCidade();
	}
	
	@CommandHandler
	public ClienteAggregate(AtualizarClienteCommand command) {
		this.setId(command.getId());
		 AggregateLifecycle.apply(
		            new ClienteAtualizadoEvent(
		                    command.getId(),
		                    command.getNomeCompleto(),
		                    command.getSexo(),
		                    command.getDataNascimento(),
		                    command.getCidade(),
		                    command.getIdAtual(),
		                    null
		                    
		            )
		    );
	}
	
	@EventSourcingHandler
	public void on(ClienteAtualizadoEvent event) {
		this.setId(event.getId());
		this.nomeCompleto = event.getNomeCompleto();
		this.sexo = event.getSexo();
		this.dataNascimento = event.getDataNascimento();
		this.cidade = event.getCidade();
	}
	
	@CommandHandler
	public  ClienteAggregate(RemoverClienteCommand command) {
		 AggregateLifecycle.apply(
		            new ClienteRemovidoEvent(
		                    command.getId()
		            )
		    );
	}
	
	@EventSourcingHandler
	public void on(ClienteRemovidoEvent event) {
		this.setId(event.getId());
	}

	

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public void setId(UUID id) {
		this.id = id;
	}
    
}
