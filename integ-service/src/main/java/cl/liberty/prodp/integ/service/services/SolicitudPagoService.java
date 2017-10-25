package cl.liberty.prodp.integ.service.services;

import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.SolicitudPagoPModel;
import cl.liberty.prodp.integ.commons.responses.SolicitudPagoRegResponse;

public interface SolicitudPagoService {

	SolicitudPagoRegResponse registrarSolicitudPago(SolicitudPagoPModel solPago) throws IntegSoapPentaExcepcion;
}
