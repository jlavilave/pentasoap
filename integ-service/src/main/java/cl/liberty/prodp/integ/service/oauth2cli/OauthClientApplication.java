package cl.liberty.prodp.integ.service.oauth2cli;

import java.io.IOException;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import cl.liberty.prodp.integ.commons.enums.ScopesOAuth2Enum;
import cl.liberty.prodp.integ.service.utils.Propiedades;

@SpringBootApplication
@EnableOAuth2Client
public class OauthClientApplication extends SpringBootServletInitializer{
	
	private static final Logger LOG = Logger.getLogger(OauthClientApplication.class);
	
//	@Value("${config.oauth2.accessTokenUri}")
//    private String accessTokenUri;
//
//    @Value("${config.oauth2.userAuthorizationUri}")
//    private String userAuthorizationUri;
//
//    @Value("${config.oauth2.clientID}")
//    private String clientID;
//
//    @Value("${config.oauth2.clientSecret}")
//    private String clientSecret;
//
//    @Value("${config.oauth2.resourceId}")
//    private String resourceId;

    @Autowired(required=true)
	private Propiedades msgValid;
    
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OauthClientApplication.class);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(OauthClientApplication.class, args);
	}
	
	/**
     * The heart of our interaction with the resource; handles redirection for authentication, 
     * access tokens, etc.
     * 
     * @param oauth2ClientContext
     * @return
     */
//    @Bean
//    public OAuth2RestOperations restTemplate() {
//        AccessTokenRequest atr = new DefaultAccessTokenRequest();
//        return new OAuth2RestTemplate(resource(ScopesOAuth2Enum.SCOPE_CONTABILIDAD_REGISTRAR.getScope()), 
//                        new DefaultOAuth2ClientContext(atr));
//    }
    
    
    @Bean
    public OAuth2RestOperations restTemplateRCTB() throws IOException{
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource(ScopesOAuth2Enum.SCOPE_CONTABILIDAD_REGISTRAR.getScope()), 
                        new DefaultOAuth2ClientContext(atr));
    }
    
    @Bean
    public OAuth2RestOperations restTemplateRCOM() throws IOException{
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource(ScopesOAuth2Enum.SCOPE_COMISION_REGISTRAR.getScope()), 
                        new DefaultOAuth2ClientContext(atr));
    }
    
    @Bean
    public OAuth2RestOperations restTemplatePWEB() throws IOException{
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource(ScopesOAuth2Enum.SCOPE_PAGO_WEB_REGISTRAR.getScope()), 
                        new DefaultOAuth2ClientContext(atr));
    }
    
    @Bean
    public OAuth2RestOperations restTemplateCCHK() throws IOException{
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource(ScopesOAuth2Enum.SCOPE_CHEQUE_CONSULTAR.getScope()), 
                        new DefaultOAuth2ClientContext(atr));
    }
    
    @Bean
    public OAuth2RestOperations restTemplateSPS() throws IOException{
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource(ScopesOAuth2Enum.SCOPE_PAGO_SIN_REGISTRAR.getScope()), 
                        new DefaultOAuth2ClientContext(atr));
    }
    
    @Bean
    public OAuth2RestOperations restTemplateRAV() throws IOException{
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource(ScopesOAuth2Enum.SCOPE_AVISO_REGISTRAR.getScope()), 
                        new DefaultOAuth2ClientContext(atr));
    }
    
    @Bean
    public OAuth2RestOperations restTemplateCAV() throws IOException{
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource(ScopesOAuth2Enum.SCOPE_AVISO_CONSULTAR.getScope()), 
                        new DefaultOAuth2ClientContext(atr));
    }

    /**
     * Define donde se encuentra el recurso a utilizar (API) y los parámetros
     * de seguridad requeridos. 
     * 
     * @see http://stackoverflow.com/questions/31452729/consume-an-oauth-secured-rest-webservice-using-spring-oauth2
     */
    private OAuth2ProtectedResourceDetails resource(String scope) throws IOException{
        ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
        AuthenticationScheme scheme = AuthenticationScheme.header;

        
        // Identificación del cliente (esta aplicación, no el usuario)
        
        resource.setClientId(msgValid.getPropertyConf("config.oauth2.clientID"));
        resource.setClientSecret(msgValid.getPropertyConf("config.oauth2.clientSecret"));
//        resource.setId(resourceId);
        
        // URI para obtener token de acceso y autorización (scopes)
        
        resource.setAccessTokenUri(msgValid.getPropertyConf("config.oauth2.accessTokenUri"));
        
        //resource.setUserAuthorizationUri(userAuthorizationUri);
        //resource.setGrantType("client_credentials,refresh_token,authorization_code");  // TODO separar e importar modelo desde server
        // Scope solicitado
        resource.setScope(Arrays.asList(scope));

        resource.setClientAuthenticationScheme(AuthenticationScheme.header);
        
        return resource;
    }
    
}
