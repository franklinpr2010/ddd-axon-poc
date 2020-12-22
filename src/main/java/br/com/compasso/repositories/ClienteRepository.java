package br.com.compasso.repositories;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import br.com.compasso.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, UUID> {

	/**
	 * Consultar cliente pelo nome completo
	 *
	 * @param nome
	 * @return
	 */
	Optional<Cliente> findByNomeCompletoAllIgnoreCase(String nome);
	 

	
}
