package br.com.compasso.event;

import java.util.UUID;

import br.com.compasso.enums.EstadoEnum;
import lombok.Data;

@Data
public class CidadeCriadoEvent {
	
	public CidadeCriadoEvent(UUID id, String nome, EstadoEnum estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

    private UUID id;
	
	private String nome;

	private EstadoEnum estado;

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
