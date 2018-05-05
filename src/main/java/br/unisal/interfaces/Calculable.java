package br.unisal.interfaces;

import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.soap.SOAPException;

import br.unisal.exceptions.DivisionByZeroArithymeticException;

import static br.unisal.util.Constants.*;

/**
 * 
 * @author jether.rodrigues
 *
 * Style.RPC: menos verboso, menos detalhes
 * Style.DOCUMENT: mais verboso, gera mais detalhes
 */

@WebService
@SOAPBinding(style = Style.DOCUMENT) 
public interface Calculable {
	
	@WebMethod(action=HOST + "/divide", operationName="division")
	public double divide(
		@WebParam(name = "dividend") double dividend,
		@WebParam(name = "divisor") double divisor
	) throws DivisionByZeroArithymeticException, SOAPException;
}
