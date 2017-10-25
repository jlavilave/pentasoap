package cl.liberty.prodp.integ.service.restclient;


import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.enums.ScopesOAuth2Enum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.ParamConsultaChequePModel;
import cl.liberty.prodp.integ.commons.responses.ConsultaChequeResponse;
import cl.liberty.prodp.integ.service.helper.ConvertObjToStringXml;

@Repository("chequeRestClient")
public class ChequeRestClient extends PentaRestClient {
	
	private static final Logger LOGGER = Logger.getLogger(ChequeRestClient.class);

	@Autowired(required=true)
	private ConvertObjToStringXml convertObjToStringXml;
	
	private static final String METHOD_POST = "POST";
	
	public ConsultaChequeResponse obtener(ParamConsultaChequePModel param) {
		
		ConsultaChequeResponse ch;
		
		try {
			String input = convertObjToStringXml.objectToXml(param, ParamConsultaChequePModel.class);
			String output = super.callService("cheque/obtener",input, METHOD_POST,
					ScopesOAuth2Enum.SCOPE_CHEQUE_CONSULTAR.getId());
			ch = (ConsultaChequeResponse)convertObjToStringXml.xmlToObject(output, ConsultaChequeResponse.class);
		} catch (JAXBException e) {
			LOGGER.error(ChequeRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_CONVERSION_XML.getCodigo(), e.getMessage());			
		} catch (IntegSoapPentaExcepcion e) {
			LOGGER.error(ChequeRestClient.class.getSimpleName() + " : " + e, e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(ChequeRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
		} 
		return ch;
	}
	
}
