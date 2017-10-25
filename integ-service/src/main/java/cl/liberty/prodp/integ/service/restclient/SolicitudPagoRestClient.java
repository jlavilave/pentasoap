package cl.liberty.prodp.integ.service.restclient;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.enums.ScopesOAuth2Enum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.SolicitudPagoPModel;
import cl.liberty.prodp.integ.commons.responses.SolicitudPagoRegResponse;
import cl.liberty.prodp.integ.service.helper.ConvertObjToStringXml;

@Repository("solicitudPagoRestClient")
public class SolicitudPagoRestClient extends PentaRestClient {
	
	private static final Logger LOGGER = Logger.getLogger(SolicitudPagoRestClient.class);

	@Autowired(required=true)
	private ConvertObjToStringXml convertObjToStringXml;
	
	private static final String METHOD_POST = "POST";
	
	public SolicitudPagoRegResponse registrar(SolicitudPagoPModel solPago)
			throws IntegSoapPentaExcepcion {
		
		SolicitudPagoRegResponse sp;
		
		try {
			String input = convertObjToStringXml.objectToXml(solPago, SolicitudPagoPModel.class);
			String output = super.callService("solicitudpago/registrar",input, METHOD_POST, 
					ScopesOAuth2Enum.SCOPE_PAGO_SIN_REGISTRAR.getId());
			sp = (SolicitudPagoRegResponse)convertObjToStringXml.xmlToObject(output, SolicitudPagoRegResponse.class);
		} catch (JAXBException e) {
			LOGGER.error(SolicitudPagoRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_CONVERSION_XML.getCodigo(), e.getMessage());
		} catch (IntegSoapPentaExcepcion e) {
			LOGGER.error(ChequeRestClient.class.getSimpleName() + " : " + e, e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(SolicitudPagoRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
		} 
		return sp;
	}
}
