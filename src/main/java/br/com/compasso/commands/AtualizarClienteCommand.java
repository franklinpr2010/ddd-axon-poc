package br.com.compasso.commands;

import java.util.Date;
import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import br.com.compasso.entity.Cidade;
import br.com.compasso.enums.EstadoEnum;
import br.com.compasso.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtualizarClienteCommand {
	
	@TargetAggregateIdentifier
	private UUID id;
	private String nomeCompleto;
	private SexoEnum sexo;
	private Date dataNascimento;
	private Cidade cidade;
	private Integer idade;
	private UUID idAtual;
	
}
