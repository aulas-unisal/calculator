package br.unisal.exceptions;

/**
 * 
 * @author jether.rodrigues
 *
 *         Poderia utilizar "extends Exception", no entanto é muito genérico já
 *         que o domínio do serviço é voltado a operações matemáticas
 */
public class DivisionByZeroArithymeticException extends ArithmeticException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3966478940709679190L;

	public DivisionByZeroArithymeticException() {
	}
	
	public DivisionByZeroArithymeticException(String errorMessage) {
		super(errorMessage);
	}
}
