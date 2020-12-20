package br.com.compasso.exceptions;

/**
 * Classe de excessões para a cidade
 * @author franklin.roza
 *
 */
public class DuplicationAttributeException extends RuntimeException {

	private static final long serialVersionUID = 1831031278226992953L;
	
	public DuplicationAttributeException(String atributo, String valor) {
		super("Já existe no banco o valor " + valor + " para o atributo " + atributo);
	}
}
