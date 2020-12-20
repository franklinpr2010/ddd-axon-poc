package br.com.compasso.query;

import java.util.UUID;

public class BuscarCidadePorIdQuery {

	public BuscarCidadePorIdQuery(UUID cidadeId) {
		this.cidadeId = cidadeId;
	}
	
	private UUID cidadeId;
	
	public UUID getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(UUID cidadeId) {
		this.cidadeId = cidadeId;
	}



}
