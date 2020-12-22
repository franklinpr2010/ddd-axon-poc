package br.com.compasso.viewmodel;

import java.util.Date;
import java.util.UUID;

import br.com.compasso.entity.Cidade;
import br.com.compasso.enums.EstadoEnum;
import br.com.compasso.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CidadeViewModel {

	
    private UUID id;
	
	private String nome;

	private EstadoEnum estado;

	

}
