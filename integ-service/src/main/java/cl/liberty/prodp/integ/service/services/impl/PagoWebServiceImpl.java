package cl.liberty.prodp.integ.service.services.impl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.enums.CodigosValidacionesEnum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.DetallePagoWebPModel;
import cl.liberty.prodp.integ.commons.model.PagoWebPModel;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.commons.responses.PagoWebResponse;
import cl.liberty.prodp.integ.service.restclient.PagoWebRestClient;
import cl.liberty.prodp.integ.service.services.PagoWebService;
import cl.liberty.prodp.integ.service.utils.ValidacionesServices;
import cl.liberty.prodp.integ.service.validation.ValidationBusinessPagoWeb;
import cl.liberty.prodp.integ.service.validation.ValidatorIntegrity;

@Service("pagoWebService")
public class PagoWebServiceImpl implements PagoWebService {

	private static final Logger LOGGER = Logger.getLogger(PagoWebServiceImpl.class);
	
	@Autowired(required=true)
	private PagoWebRestClient pagoWebRestClient;
	
	@Autowired(required=true)
	private ValidationBusinessPagoWeb validationBusinessPagoWeb;
	
	@Autowired(required=true)
	private ValidatorIntegrity validatorIntegrity;

	
	public PagoWebResponse registrarPagoWeb(PagoWebPModel pagoWeb)
			throws IntegSoapPentaExcepcion {
		
		PagoWebResponse response = new PagoWebResponse();
		ErrorResponse err = new ErrorResponse();
		List<ErrorResponse> listErr;
		
		try {
			listErr = validatorIntegrity.validar(pagoWeb);
			validarListado(pagoWeb, listErr);
			
			if (listErr.isEmpty()) {
				listErr = validationBusinessPagoWeb.validar(pagoWeb);
				if (listErr.isEmpty()) {
					response = pagoWebRestClient.registrar(pagoWeb);
				}
			}
			
			err = ValidacionesServices.validarListError(listErr);
		} catch (IntegSoapPentaExcepcion e) {
			err.setCodigo(e.getCodigoExcepcion());
			err.setMensaje(e.getGlosaExcepcion());
			LOGGER.error(PagoWebServiceImpl.class.getSimpleName() + " : " + e, e); 
		} catch (IOException e) {
			err.setCodigo(CodigosComunesEnum.ERROR_ARCHIVO_PROPERTIES.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(PagoWebServiceImpl.class.getSimpleName() + " : " + e, e);
		} catch (Exception e) {
			err.setCodigo(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo());
			err.setMensaje(e.getMessage());
			LOGGER.error(PagoWebServiceImpl.class.getSimpleName() + " : " + e, e);
		}
		if(err != null){
			response.setError(err);
		}
		
		return response;
	}
	
	private void validarListado(PagoWebPModel pagoWeb, List<ErrorResponse> listErr) throws IOException{
		
		if(listErr.isEmpty()){
			validatorIntegrity.validarListadoVacio(pagoWeb.getDetalles(), listErr, CodigosValidacionesEnum.PW_NULO_DETALLES);
		}
		if(listErr.isEmpty()){
			for (DetallePagoWebPModel det : pagoWeb.getDetalles()) {
				listErr.addAll(validatorIntegrity.validar(det, String.valueOf(det.getNumeroCorrelativo())));
			}
		}
		
	}

}
