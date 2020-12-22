package br.com.compasso.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.compasso.enums.EstadoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade cidade
 * @author franklin.roza
 *
 */
@org.hibernate.annotations.GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COMPASSO_CIDADE")
public class Cidade {

	private static final long serialVersionUID = -1903052243314924034L;

	
	@Id
	@GeneratedValue(generator = "UUID")
    private UUID id;
	
	private String nome;
	
	@Enumerated(EnumType.ORDINAL)
	private EstadoEnum estado;


	
}
