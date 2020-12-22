package br.com.compasso.commands;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemoverClienteCommand {
	
	
	
	@TargetAggregateIdentifier
	private UUID id;
	
	



}
