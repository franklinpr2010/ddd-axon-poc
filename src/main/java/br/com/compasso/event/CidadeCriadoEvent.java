package br.com.compasso.event;

import java.util.UUID;

import br.com.compasso.enums.EstadoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CidadeCriadoEvent {
	

    private UUID id;
	
	private String nome;

	private EstadoEnum estado;

	

}
