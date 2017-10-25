package cl.liberty.prodp.integ.commons.responses;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "consultaChequeResponse")
public class ConsultaChequeResponse implements Serializable{

	private static final long serialVersionUID = 5478584090330089367L;

	private ChequeResponse cheque;
	
	private ErrorResponse error;

	@XmlElement(name="cheque")
	public ChequeResponse getCheque() {
		return cheque;
	}

	public void setCheque(ChequeResponse cheque) {
		this.cheque = cheque;
	}

	@XmlElement(name="error")
	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}
	
}
