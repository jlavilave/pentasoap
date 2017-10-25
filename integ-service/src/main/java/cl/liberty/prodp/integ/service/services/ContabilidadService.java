package cl.liberty.prodp.integ.service.services;

import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.ComprobanteContPModel;
import cl.liberty.prodp.integ.commons.responses.ContabilidadResponse;

public interface ContabilidadService {

	ContabilidadResponse registrar(ComprobanteContPModel c) throws IntegSoapPentaExcepcion;
	
}
