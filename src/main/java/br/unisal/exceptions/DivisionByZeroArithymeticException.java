package br.unisal.exceptions;

/**
 * 
 * @author jether.rodrigues
 * 
 */
public class DivisionByZeroArithymeticException extends ArithmeticException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3966478940709679190L;

	public DivisionByZeroArithymeticException() {
	}
	
	public DivisionByZeroArithymeticException(String message) {
		super(message);
	}
}
