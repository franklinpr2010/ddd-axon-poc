package br.com.compasso.exceptions;

public class ApplicationException extends IllegalArgumentException {

	private static final long serialVersionUID = 7567380438337351450L;

	public ApplicationException() {
		// TODO Auto-generated constructor stub
	}
	
	public ApplicationException(String message) {
		super(message);
	}

}
