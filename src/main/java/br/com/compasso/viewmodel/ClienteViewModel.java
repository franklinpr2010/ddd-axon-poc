package br.com.compasso.viewmodel;

import java.util.Date;
import java.util.UUID;

import br.com.compasso.entity.Cidade;
import br.com.compasso.enums.SexoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteViewModel {
	private UUID id;
	private String nomeCompleto;
	private SexoEnum sexo;
	private Date dataNascimento;
	private Cidade cidade;
}
