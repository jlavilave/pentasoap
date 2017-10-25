package cl.liberty.prodp.integ.service.oauth2cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.common.OAuth2AccessToken;


//@RestController
public class UserController {

	@Autowired
    private OAuth2RestOperations restTemplate;
	
	@Value("${config.oauth2.resourceURI}")
	private String resourceURI;

//	@RequestMapping("/remoteresource")
    public String home() {
        OAuth2AccessToken token =  restTemplate.getAccessToken();
        String result = restTemplate.getForObject(resourceURI, String.class);

        return result;
    }
    
//    @RequestMapping("/localresource")
    public String unsecure() {
        return "Hello Unsecure World";
    }
}
