package br.unisal.service;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;

import br.unisal.exceptions.CalculatorSOAPFaultException;
import br.unisal.exceptions.DivisionByZeroArithymeticException;
import br.unisal.interfaces.Calculable;

/**
 * 
 * @author jether.rodrigues
 *
 */
@WebService(endpointInterface = "br.unisal.interfaces.Calculable"
	, name = "CalculatorService"
	, serviceName = "CalculatorService"
	, targetNamespace = "http://jetherrodrigues.com/jaxws/calculator"
)
public class CalculatorService implements Calculable {
	
	private final static String SERVICE = "CalculatorService"; 
	
	@Override
	public double add(double portion1, double portion2) {
		return portion1 + portion2;
	}

	@Override
	public double subtract(double portion1, double portion2) {
		return portion1 - portion2;
	}

	@Override
	public double multiply(double factor1, double factor2) {
		return factor1 * factor2;
	}
	
	@Override
	public double divide(double dividend, double divisor) throws SOAPException {
		if (divisor == 0) {
			throw new CalculatorSOAPFaultException(
					CalculatorSOAPFaultException
						.getSoapFactory()
						.createFault(
								new DivisionByZeroArithymeticException("O divisor não pode ser igual a Zero.").getMessage(),
								new QName("http://schemas.xmlsoap.org/soap/envelope/",
								SERVICE)));
		}

		if (divisor < 0) {
			throw new CalculatorSOAPFaultException(
					CalculatorSOAPFaultException
						.getSoapFactory()
						.createFault(
								new IllegalArgumentException("Divisor não pode ser números negativos.").getMessage(),
								new QName("http://schemas.xmlsoap.org/soap/envelope/",
								SERVICE)));
		}

		return dividend / divisor;
	}
}
