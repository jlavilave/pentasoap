package cl.liberty.prodp.integ.service.services;

import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.AvisoPModel;
import cl.liberty.prodp.integ.commons.model.ParamConsultaEstadoPModel;
import cl.liberty.prodp.integ.commons.responses.AvisoRegResponse;
import cl.liberty.prodp.integ.commons.responses.ConsultaEstadoResponse;

public interface AvisoService {
	
	AvisoRegResponse registrarAviso(AvisoPModel aviso) throws IntegSoapPentaExcepcion;
	
	ConsultaEstadoResponse obtenerEstadoAviso(ParamConsultaEstadoPModel param) throws IntegSoapPentaExcepcion;

}
