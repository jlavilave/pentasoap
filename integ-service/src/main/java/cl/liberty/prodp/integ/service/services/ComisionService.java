package cl.liberty.prodp.integ.service.services;

import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.ComisionPModel;
import cl.liberty.prodp.integ.commons.responses.ComisionRegResponse;

public interface ComisionService {

	ComisionRegResponse registrarComision(ComisionPModel comision) throws IntegSoapPentaExcepcion;
	
}
