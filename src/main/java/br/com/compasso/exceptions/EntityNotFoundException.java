package br.com.compasso.exceptions;

/**
 * Classe de excessões para a cidade
 * @author franklin.roza
 *
 */
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1831031278226992953L;

	public EntityNotFoundException(Long id) {
		super("Não foi encontrado a cidade com o id " + id);
	}
	
	public EntityNotFoundException(String atributo, String valor) {
		super("Não foi encontrada nenhuma referência com o valor do atributo " + atributo + " com " + valor);
	}
}
