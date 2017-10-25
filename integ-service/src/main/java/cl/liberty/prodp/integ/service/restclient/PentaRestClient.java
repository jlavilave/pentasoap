package cl.liberty.prodp.integ.service.restclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownServiceException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import cl.liberty.prodp.integ.commons.enums.CodigosComunesEnum;
import cl.liberty.prodp.integ.commons.exceptions.IntegSoapPentaExcepcion;
import cl.liberty.prodp.integ.service.utils.Propiedades;

@ComponentScan("cl.liberty.prodp.integ.service.oauth2cli")
public class PentaRestClient {

	private static final Logger LOGGER = Logger.getLogger(PentaRestClient.class);
	
	@Autowired(required=true)
	private Propiedades msgValid;

	@Autowired
	private OAuth2RestOperations restTemplateRCTB;

	@Autowired
	private OAuth2RestOperations restTemplateRCOM;

	@Autowired
	private OAuth2RestOperations restTemplatePWEB;

	@Autowired
	private OAuth2RestOperations restTemplateCCHK;

	@Autowired
	private OAuth2RestOperations restTemplateSPS;

	@Autowired
	private OAuth2RestOperations restTemplateRAV;

	@Autowired
	private OAuth2RestOperations restTemplateCAV;
	
	protected String callService(String urlService, String param, String method, Integer idSrv) throws IntegSoapPentaExcepcion{
		
		String response = "";
		String out;
		String valToken = "";

		try {
			URL url = this.getUrl(urlService);
			HttpURLConnection conn = this.getConnection(url, method);	
			valToken = this.getToken(idSrv);
			
			conn.setDoOutput(true);
			conn.setRequestMethod(method);
			conn.setRequestProperty("Authorization", "Bearer ".concat(valToken));
			conn.setRequestProperty("Content-Type", "application/xml; charset=utf-8");
			conn.setRequestProperty("Accept", "application/xml");
			
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
			writer.write(param);
			writer.close();
			wr.close();
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "UTF-8"));
			response = "";	
			
			while ((out = br.readLine()) != null) {
				response = out;
			}
			conn.disconnect();
			br.close();
			
		} catch (SocketTimeoutException e){ 
			LOGGER.error(PentaRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_RESTCLIENT_TIMEOUT.getCodigo(), e.getMessage());
		}  catch (UnknownServiceException e) {
			LOGGER.error(PentaRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_RESTCLIENT_TIMEOUT.getCodigo(), e.getMessage());
		} catch (IOException e) {
			LOGGER.error(PentaRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_RESTCLIENT_FILESTREAM.getCodigo(), e.getMessage());
		} catch (Exception e) {
			LOGGER.error(PentaRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
		}
		return response;
	}
	
	
	private URL getUrl(String urlService) {
		
		String host, port, urlApp, urlFull, protocolo;
		try {
			protocolo = msgValid.getPropertyConf("liberty.protocolo.http");
			host = msgValid.getPropertyConf("liberty.host");
			port = msgValid.getPropertyConf("liberty.port");
			
			if(!port.equals("")){
				port=":".concat(port);
			}
			
			urlApp = msgValid.getPropertyConf("liberty.nombre.app");
			
			urlFull = protocolo.concat("://").concat(host).concat(port)
					.concat("/").concat(urlApp).concat("/").concat(urlService);
			
			return new URL(urlFull);
		} catch (MalformedURLException e) {
			LOGGER.error(PentaRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_RESTCLIENT_BADREQUEST.getCodigo(), e.getMessage());
		} catch (Exception e) {
			LOGGER.error(PentaRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
		}
	}
	
	private HttpURLConnection getConnection(URL url, String method) {
		
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(method);
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setConnectTimeout(10000);
			
			return conn;
		} catch (ProtocolException e) {
			LOGGER.error(PentaRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_RESTCLIENT_BADREQUEST.getCodigo(), e.getMessage());
		} catch (Exception e) {
			LOGGER.error(PentaRestClient.class.getSimpleName() + " : " + e, e);
			throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_NO_DIFERENCIABLE.getCodigo(), e.getMessage());
		}
	}
	
	private String getToken(int idSrv) throws IOException{

		OAuth2AccessToken token;		
		switch (idSrv) {
			case 1:
				token = restTemplateRAV.getAccessToken();
				break;
	        case 2:
	        	token = restTemplateCAV.getAccessToken();
	        	break;
	        case 3:
				token = restTemplateSPS.getAccessToken();
				break;
	        case 4:
				token = restTemplateCCHK.getAccessToken();
				break;
	        case 5:
				token = restTemplateRCOM.getAccessToken();
				break;
	        case 6:
				token = restTemplatePWEB.getAccessToken();
				break;
	        case 7:
				token = restTemplateRCTB.getAccessToken();
				break;
			default:
				throw new IntegSoapPentaExcepcion(CodigosComunesEnum.ERROR_RESTCLIENT_ERROAUTH2.getCodigo(), 
						msgValid.getProperty("valid.oauth2.err"));
		}
		
		return token.getValue();
	}
}
