package cl.liberty.prodp.integ.service.services.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.AsientoContPModel;
import cl.liberty.prodp.integ.commons.model.ComprobanteContPModel;
import cl.liberty.prodp.integ.commons.responses.ContabilidadResponse;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.service.restclient.ContabilidadRestClient;
import cl.liberty.prodp.integ.service.services.ContabilidadService;
import cl.liberty.prodp.integ.service.utils.ValidacionesServices;
import cl.liberty.prodp.integ.service.validation.ValidatorBusinessContabilidad;
import cl.liberty.prodp.integ.service.validation.ValidatorIntegrity;

@Service("contabilidadService")
public class ContabilidadServiceImpl implements ContabilidadService{

	private static final Logger LOGGER = Logger.getLogger(ContabilidadServiceImpl.class);
	
	@Autowired(required=true)
	private ContabilidadRestClient contabilidadRestClient;
	
	@Autowired(required=true)
	private ValidatorIntegrity validatorIntegrity;
	
	@Autowired(required=true)
	private ValidatorBusinessContabilidad validatorBusinessContabilidad;
	
	@Override
	public ContabilidadResponse registrar(ComprobanteContPModel c)
			throws IntegSoapPentaExcepcion {
				
		ContabilidadResponse response = new ContabilidadResponse();
		ErrorResponse err = new ErrorResponse();
		List<ErrorResponse> listErr;
		
		try {
			listErr = validatorIntegrity.validar(c);
			for (AsientoContPModel as : c.getAsientos()) {
				listErr.addAll(validatorIntegrity.validar(as, String.valueOf(as.getNumeroAsiento())));
			}
			
			if (listErr.isEmpty()) {
				listErr = validatorBusinessContabilidad.validar(c);
				if (listErr.isEmpty()) {
					response = contabilidadRestClient.registrar(c);
				}
			}
			err = ValidacionesServices.validarListError(listErr);
		} catch (IntegSoapPentaExcepcion e) {
			err.setCodigo(e.getCodigoExcepcion());
			err.setMensaje(e.getGlosaExcepcion());
			LOGGER.error(ContabilidadServiceImpl.class.getSimpleName() + ", registrar()" + " : " + e, e);
		} catch (IOException e) {
			err.setCodigo(CodigosComunesEnum.ERROR_ARCHIVO_PROPERTIES.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(ContabilidadServiceImpl.class.getSimpleName() + ", registrar()" + " : " + e, e);
		}  catch (Exception e) {
			err.setCodigo(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(ContabilidadServiceImpl.class.getSimpleName() + ", registrar()" + " : " + e, e);
		} 
		if(err != null){
			response.setError(err);
		}
		return response;
	}

}
