package br.com.compasso.query;

import java.util.UUID;

import lombok.Data;
@Data
public class BuscarClientePorIdQuery {
	

	private UUID clienteId;

	public BuscarClientePorIdQuery(UUID clienteId) {
		this.clienteId = clienteId;
	}
	
	public UUID getClienteId() {
		return clienteId;
	}

	public void setClienteId(UUID clienteId) {
		this.clienteId = clienteId;
	}

	




}
