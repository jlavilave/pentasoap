package cl.liberty.prodp.integ.service.restclient;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.enums.ScopesOAuth2Enum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.ComisionPModel;
import cl.liberty.prodp.integ.commons.responses.ComisionRegResponse;
import cl.liberty.prodp.integ.service.helper.ConvertObjToStringXml;

@Repository("comisionRestClient")
public class ComisionRestClient extends PentaRestClient {

	private static final Logger LOGGER = Logger.getLogger(ComisionRestClient.class);

	@Autowired(required=true)
	private ConvertObjToStringXml convertObjToStringXml;
	
	private static final String METHOD_POST = "POST";
	
	public ComisionRegResponse registrar(ComisionPModel c) {
		
		ComisionRegResponse cr;
		
		try {
			String input = convertObjToStringXml.objectToXml(c, ComisionPModel.class);
			String output = super.callService("comision/registrar",input, METHOD_POST,
					ScopesOAuth2Enum.SCOPE_COMISION_REGISTRAR.getId());
			cr = (ComisionRegResponse)convertObjToStringXml.xmlToObject(output, ComisionRegResponse.class);
		} catch (JAXBException e) {
			LOGGER.error(ComisionRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_CONVERSION_XML.getCodigo(), e.getMessage());			
		} catch (IntegSoapPentaExcepcion e) {
			LOGGER.error(ComisionRestClient.class.getSimpleName() + " : " + e, e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(ComisionRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
		} 
		return cr;
	}
	
}
