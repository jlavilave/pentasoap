package cl.liberty.prodp.integ.service.services;

import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.ParamConsultaChequePModel;
import cl.liberty.prodp.integ.commons.responses.ConsultaChequeResponse;

public interface ChequeService {

	ConsultaChequeResponse obtenerCheque(ParamConsultaChequePModel param) throws IntegSoapPentaExcepcion;
	
}
