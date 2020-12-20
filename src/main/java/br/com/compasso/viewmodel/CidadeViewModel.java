package br.com.compasso.viewmodel;

import java.util.UUID;

import br.com.compasso.enums.EstadoEnum;

public class CidadeViewModel {

	public CidadeViewModel() {
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
