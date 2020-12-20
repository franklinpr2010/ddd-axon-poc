package br.com.compasso.repositories;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.compasso.entity.Cidade;
import br.com.compasso.enums.EstadoEnum;

public interface CidadeRepository extends CrudRepository<Cidade, UUID> {

	/**
	 * Consultar cidade pelo nome
	 * @param customer
	 * @return cidade
	 */
	Optional<Cidade> findByNomeAllIgnoreCase(String nome);
	 
	 /**
     * Consultar cidade pelo estado
	 * @param customer
	 * @return cidade
	 */
	Optional<Cidade> findByEstado(EstadoEnum estado);
	 
	 

	
}
