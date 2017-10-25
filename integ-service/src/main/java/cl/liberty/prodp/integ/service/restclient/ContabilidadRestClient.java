package cl.liberty.prodp.integ.service.restclient;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.enums.ScopesOAuth2Enum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.ComprobanteContPModel;
import cl.liberty.prodp.integ.commons.responses.ContabilidadResponse;
import cl.liberty.prodp.integ.service.helper.ConvertObjToStringXml;

@Repository("contabilidadRestClient")
public class ContabilidadRestClient extends PentaRestClient{
	
private static final Logger LOGGER = Logger.getLogger(ContabilidadRestClient.class);
	
	@Autowired(required=true)
	private ConvertObjToStringXml convertObjToStringXml;
	
	private static final String METHOD_POST = "POST";
	
	public ContabilidadResponse registrar(ComprobanteContPModel com) throws IntegSoapPentaExcepcion{
		
		ContabilidadResponse c;
		
		try {
			String input = convertObjToStringXml.objectToXml(com, ComprobanteContPModel.class);
			String output = super.callService("contabilidad/registrar",input, METHOD_POST,
					ScopesOAuth2Enum.SCOPE_CONTABILIDAD_REGISTRAR.getId());
			c = (ContabilidadResponse)convertObjToStringXml.xmlToObject(output, ContabilidadResponse.class);
		} catch (JAXBException e) {
			LOGGER.error(ContabilidadRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_CONVERSION_XML.getCodigo(), e.getMessage());
		} catch (IntegSoapPentaExcepcion e) {
			LOGGER.error(ContabilidadRestClient.class.getSimpleName() + " : " + e, e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(ContabilidadRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
		} 
		return c;
	}

}
