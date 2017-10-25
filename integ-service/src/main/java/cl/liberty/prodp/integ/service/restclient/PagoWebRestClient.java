package cl.liberty.prodp.integ.service.restclient;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.enums.ScopesOAuth2Enum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.PagoWebPModel;
import cl.liberty.prodp.integ.commons.responses.PagoWebResponse;
import cl.liberty.prodp.integ.service.helper.ConvertObjToStringXml;

@Repository("pagoWebRestClient")
public class PagoWebRestClient extends PentaRestClient {

	private static final Logger LOGGER = Logger.getLogger(PagoWebRestClient.class);

	@Autowired(required=true)
	private ConvertObjToStringXml convertObjToStringXml;
	
	private static final String METHOD_POST = "POST";
	
	public PagoWebResponse registrar(PagoWebPModel pw) {
		
		PagoWebResponse pwr;
		
		try {
			String input = convertObjToStringXml.objectToXml(pw, PagoWebPModel.class);
			String output = super.callService("pagoweb/registrar",input, METHOD_POST,
					ScopesOAuth2Enum.SCOPE_PAGO_WEB_REGISTRAR.getId());
			pwr = (PagoWebResponse)convertObjToStringXml.xmlToObject(output, PagoWebResponse.class);
		} catch (JAXBException e) {
			LOGGER.error(PagoWebRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_CONVERSION_XML.getCodigo(), e.getMessage());			
		} catch (IntegSoapPentaExcepcion e) {
			LOGGER.error(PagoWebRestClient.class.getSimpleName() + " : " + e, e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(PagoWebRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
		} 
		return pwr;
	}
	
}
