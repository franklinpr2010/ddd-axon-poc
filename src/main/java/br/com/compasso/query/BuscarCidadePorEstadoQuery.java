package br.com.compasso.query;

import br.com.compasso.enums.EstadoEnum;

public class BuscarCidadePorEstadoQuery {
	
	private EstadoEnum estadoEnum;

	public BuscarCidadePorEstadoQuery(EstadoEnum estadoEnum) {
		this.setEstadoEnum(estadoEnum);
	}
	
	public BuscarCidadePorEstadoQuery() {
	}

	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}

	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}
	
}
