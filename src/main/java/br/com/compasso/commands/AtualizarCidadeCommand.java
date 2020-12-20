package br.com.compasso.commands;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import br.com.compasso.enums.EstadoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AtualizarCidadeCommand {
	
	public AtualizarCidadeCommand(UUID id, String nome, EstadoEnum estado) {
		super();
		this.setId(id);
		this.nome = nome;
		this.estado = estado;
	}
	
	@TargetAggregateIdentifier
    private UUID id;
	
	private String nome;

	private EstadoEnum estado;

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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}


	
}
	
