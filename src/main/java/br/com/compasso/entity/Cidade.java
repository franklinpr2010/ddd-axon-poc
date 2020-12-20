package br.com.compasso.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.compasso.enums.EstadoEnum;

/**
 * Entidade cidade
 * @author franklin.roza
 *
 */
@org.hibernate.annotations.GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
)
@Entity(name = "CIDADE")
public class Cidade implements Serializable {

	private static final long serialVersionUID = -1903052243314924034L;


	public Cidade() {
		
	}
	
	public Cidade(UUID id, String nome, EstadoEnum estado) {
		this.estado = estado;
		this.nome = nome;
		this.id = id;
	}

	
	@Id
	@GeneratedValue(generator = "UUID")
    private UUID id;
	
	private String nome;
	
	@Enumerated(EnumType.ORDINAL)
	private EstadoEnum estado;


	public String getNome() {
		return nome;
	}

	public EstadoEnum getEstado() {
		return estado;
	}
}
