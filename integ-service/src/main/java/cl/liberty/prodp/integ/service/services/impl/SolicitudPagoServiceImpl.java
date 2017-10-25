package cl.liberty.prodp.integ.service.services.impl;

import java.io.IOException;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.enums.CodigosValidacionesEnum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.DocTributariosPModel;
import cl.liberty.prodp.integ.commons.model.SolicitudPagoPModel;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.commons.responses.SolicitudPagoRegResponse;
import cl.liberty.prodp.integ.service.restclient.SolicitudPagoRestClient;
import cl.liberty.prodp.integ.service.services.SolicitudPagoService;
import cl.liberty.prodp.integ.service.utils.ValidacionesServices;
import cl.liberty.prodp.integ.service.validation.ValidatorBusinessSolPago;
import cl.liberty.prodp.integ.service.validation.ValidatorIntegrity;

@Service("solicitudPagoService")
public class SolicitudPagoServiceImpl implements SolicitudPagoService {
	
	private static final Logger LOGGER = Logger.getLogger(SolicitudPagoServiceImpl.class);

	@Autowired(required=true)
	private SolicitudPagoRestClient solicitudPagoRestClient;
	
	@Autowired(required=true)
	private ValidatorIntegrity validatorIntegrity;
	
	@Autowired(required=true)
	private ValidatorBusinessSolPago validatorBusinessSolPago;
	
	
	@Override
	public SolicitudPagoRegResponse registrarSolicitudPago(
			SolicitudPagoPModel solPago) throws IntegSoapPentaExcepcion {
		
		SolicitudPagoRegResponse response = new SolicitudPagoRegResponse();
		ErrorResponse err = new ErrorResponse();
		List<ErrorResponse> listErr;
		
		try {
			listErr = validatorIntegrity.validar(solPago);
			validarListado(solPago, listErr);
			
			if (listErr.isEmpty()) {
				listErr = validatorBusinessSolPago.validar(solPago);
				if (listErr.isEmpty()) {
					response = solicitudPagoRestClient.registrar(solPago);
				}
			}
			err = ValidacionesServices.validarListError(listErr);
		} catch (IntegSoapPentaExcepcion e) {
			err.setCodigo(e.getCodigoExcepcion());
			err.setMensaje(e.getGlosaExcepcion());
			LOGGER.error(SolicitudPagoServiceImpl.class.getSimpleName() + " : " + e, e);
		} catch (IOException e) {
			err.setCodigo(CodigosComunesEnum.ERROR_ARCHIVO_PROPERTIES.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(SolicitudPagoServiceImpl.class.getSimpleName() + " : " + e, e);
		}  catch (Exception e) {
			err.setCodigo(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(SolicitudPagoServiceImpl.class.getSimpleName() + " : " + e, e);
		} 
		if(err != null){
			response.setError(err);
		}
		return response;
	}
	
	private void validarListado(SolicitudPagoPModel solPago, List<ErrorResponse> listErr) throws IOException{
		
		if(listErr.isEmpty()){
			validatorIntegrity.validarListadoVacio(solPago.getDocumentos(), listErr, CodigosValidacionesEnum.NULO_LISTADO_DOCS);
		}
		if(listErr.isEmpty()){
			for (DocTributariosPModel doc : solPago.getDocumentos()) {
				listErr.addAll(validatorIntegrity.validar(doc, String.valueOf(doc.getNumDocumento())));
			}
		}
		
	}

}
