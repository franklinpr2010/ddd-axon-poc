package br.com.compasso.commands;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RemoverClienteCommand {
	public RemoverClienteCommand(UUID id) {
		super();
		this.setId(id);
	}
	
	@TargetAggregateIdentifier
	@Getter
	private UUID id;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}



}
