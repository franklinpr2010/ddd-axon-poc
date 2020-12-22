package br.com.compasso.query;

import br.com.compasso.enums.EstadoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuscarCidadePorEstadoQuery {
	
	private EstadoEnum estadoEnum;

	
}
