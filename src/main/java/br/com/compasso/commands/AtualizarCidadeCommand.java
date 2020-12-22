package br.com.compasso.commands;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import br.com.compasso.enums.EstadoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AtualizarCidadeCommand {
	
	public AtualizarCidadeCommand() {
		
	}

	
	@TargetAggregateIdentifier
    private UUID id;
	
	private String nome;

	private EstadoEnum estado;


	
}
	
