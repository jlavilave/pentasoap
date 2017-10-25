package cl.liberty.prodp.integ.service.services;

import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.PagoWebPModel;
import cl.liberty.prodp.integ.commons.responses.PagoWebResponse;

public interface PagoWebService {

	PagoWebResponse registrarPagoWeb(PagoWebPModel pagoWeb) throws IntegSoapPentaExcepcion;
	
}
