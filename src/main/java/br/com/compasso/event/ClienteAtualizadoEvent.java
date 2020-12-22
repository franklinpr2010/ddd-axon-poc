package br.com.compasso.event;

import java.util.Date;
import java.util.UUID;

import br.com.compasso.entity.Cidade;
import br.com.compasso.enums.EstadoEnum;
import br.com.compasso.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Value;


@AllArgsConstructor
@Getter
public class ClienteAtualizadoEvent {
	
	
	private UUID id;

	private String nomeCompleto;

	private SexoEnum sexo;

	private Date dataNascimento;

	private Cidade cidade;
	
	private UUID idAtual;


	private Integer idade;

	
	

}
