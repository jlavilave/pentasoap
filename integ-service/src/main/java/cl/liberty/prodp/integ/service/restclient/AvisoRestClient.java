package cl.liberty.prodp.integ.service.restclient;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.enums.ScopesOAuth2Enum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.commons.model.AvisoPModel;
import cl.liberty.prodp.integ.commons.model.ParamConsultaEstadoPModel;
import cl.liberty.prodp.integ.commons.responses.AvisoRegResponse;
import cl.liberty.prodp.integ.commons.responses.ConsultaEstadoResponse;
import cl.liberty.prodp.integ.service.helper.ConvertObjToStringXml;

@Repository("avisoRestClient")
public class AvisoRestClient extends PentaRestClient {

	private static final Logger LOGGER = Logger.getLogger(AvisoRestClient.class);
	
	@Autowired(required=true)
	private ConvertObjToStringXml convertObjToStringXml;
	
	private static final String METHOD_POST = "POST";
	
	public AvisoRegResponse registrar(AvisoPModel aviso) throws IntegSoapPentaExcepcion {
		
		AvisoRegResponse a;
		
		try {
			String input = convertObjToStringXml.objectToXml(aviso, AvisoPModel.class);	
			String output = super.callService("aviso/registrar",input, METHOD_POST,
					ScopesOAuth2Enum.SCOPE_AVISO_REGISTRAR.getId());
			a = (AvisoRegResponse)convertObjToStringXml.xmlToObject(output, AvisoRegResponse.class);
		} catch (JAXBException e) {
			LOGGER.error(AvisoRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_CONVERSION_XML.getCodigo(), e.getMessage());
		} catch (IntegSoapPentaExcepcion e) {
			LOGGER.error(AvisoRestClient.class.getSimpleName() + " : " + e, e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(AvisoRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
		} 
		return a;
	}

	public ConsultaEstadoResponse obtenerEstado(ParamConsultaEstadoPModel param)
			throws IntegSoapPentaExcepcion {

		ConsultaEstadoResponse c;
		
		try {
			String input = convertObjToStringXml.objectToXml(param, ParamConsultaEstadoPModel.class);
			String output = super.callService("aviso/consultar/estado",input, METHOD_POST,
					ScopesOAuth2Enum.SCOPE_AVISO_CONSULTAR.getId());
			c = (ConsultaEstadoResponse)convertObjToStringXml.xmlToObject(output, ConsultaEstadoResponse.class);
		} catch (JAXBException e) {
			LOGGER.error(AvisoRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_CONVERSION_XML.getCodigo(), e.getMessage());
		} catch (IntegSoapPentaExcepcion e) {
			LOGGER.error(AvisoRestClient.class.getSimpleName() + " : " + e, e);
			throw e;
		} catch (Exception e) {
			LOGGER.error(AvisoRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
		} 
		return c;
	}
	
}
