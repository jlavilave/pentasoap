package cl.liberty.prodp.integ.service.services.impl;

import java.io.IOException;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.enums.CodigosValidacionesEnum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.AvisoPModel;
import cl.liberty.prodp.integ.commons.model.DetalleAvisoPModel;
import cl.liberty.prodp.integ.commons.model.ParamConsultaEstadoPModel;
import cl.liberty.prodp.integ.commons.responses.AvisoRegResponse;
import cl.liberty.prodp.integ.commons.responses.ConsultaEstadoResponse;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.service.restclient.AvisoRestClient;
import cl.liberty.prodp.integ.service.services.AvisoService;
import cl.liberty.prodp.integ.service.utils.ValidacionesServices;
import cl.liberty.prodp.integ.service.validation.ValidatorBusinessAviso;
import cl.liberty.prodp.integ.service.validation.ValidatorIntegrity;

@Service("avisoService")
public class AvisoServiceImpl implements AvisoService {
	
	private static final Logger LOGGER = Logger.getLogger(AvisoServiceImpl.class);

	@Autowired(required=true)
	private AvisoRestClient avisoRestClient;
	
	@Autowired(required=true)
	private ValidatorIntegrity validatorIntegrity;
	
	@Autowired(required=true)
	private ValidatorBusinessAviso validatorBusinessAviso;
	
	public AvisoRegResponse registrarAviso(AvisoPModel aviso)
			throws IntegSoapPentaExcepcion {
		
		AvisoRegResponse response = new AvisoRegResponse();
		ErrorResponse err = new ErrorResponse();
		List<ErrorResponse> listErr;
		
		try {
			listErr = validatorIntegrity.validar(aviso);
			
			validarListado(aviso, listErr);
			
			if (listErr.isEmpty()) {
				listErr = validatorBusinessAviso.validar(aviso);
				if (listErr.isEmpty()) {
					response = avisoRestClient.registrar(aviso);
				}
			}
			err = ValidacionesServices.validarListError(listErr);
		} catch (IntegSoapPentaExcepcion e) {
			err.setCodigo(e.getCodigoExcepcion());
			err.setMensaje(e.getGlosaExcepcion());
			LOGGER.error(AvisoServiceImpl.class.getSimpleName() + ", registrarAviso()" + " : " + e, e);
		} catch (IOException e) {
			err.setCodigo(CodigosComunesEnum.ERROR_ARCHIVO_PROPERTIES.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(AvisoServiceImpl.class.getSimpleName() + ", registrarAviso()" + " : " + e, e);
		}  catch (Exception e) {
			err.setCodigo(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(AvisoServiceImpl.class.getSimpleName() + ", registrarAviso()" + " : " + e, e);
		} 
		
		if(err != null){
			response.setError(err);
		}
		return response;
	}

	public ConsultaEstadoResponse obtenerEstadoAviso(ParamConsultaEstadoPModel param)
			throws IntegSoapPentaExcepcion {
		
		ConsultaEstadoResponse response = new ConsultaEstadoResponse();
		ErrorResponse err = new ErrorResponse();
		List<ErrorResponse> listErr;
		
		try {
			listErr = validatorIntegrity.validar(param);
			if (listErr.isEmpty()) {
				response = avisoRestClient.obtenerEstado(param);
			}
			err = ValidacionesServices.validarListError(listErr);
		} catch (IntegSoapPentaExcepcion e) {
			err.setCodigo(e.getCodigoExcepcion());
			err.setMensaje(e.getGlosaExcepcion());
			LOGGER.error(AvisoServiceImpl.class.getSimpleName() + ", obtenerEstadoAviso()" + " : " + e, e);
		}  catch (Exception e) {
			err.setCodigo(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(AvisoServiceImpl.class.getSimpleName() + ", obtenerEstadoAviso()" + " : " + e, e);
		} 
		if(err != null){
			response.setError(err);
		}
		return response;
	}

	private void validarListado(AvisoPModel aviso, List<ErrorResponse> listErr) throws IOException{
		
		if(listErr.isEmpty()){
			validatorIntegrity.validarListadoVacio(aviso.getDetalles(), listErr, CodigosValidacionesEnum.VACIO_DETALLES);
		}
		if(listErr.isEmpty()){
			for (DetalleAvisoPModel det : aviso.getDetalles()) {
				listErr.addAll(validatorIntegrity.validar(det, String.valueOf(det.getnReferencia())));
			}
		}
		
	}
	
}
