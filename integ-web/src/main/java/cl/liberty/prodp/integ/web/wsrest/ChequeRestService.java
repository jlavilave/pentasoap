package cl.liberty.prodp.integ.web.wsrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.liberty.prodp.integ.commons.model.ParamConsultaChequePModel;
import cl.liberty.prodp.integ.commons.responses.ConsultaChequeResponse;
import cl.liberty.prodp.integ.service.services.ChequeService;

@Path("/cheque")
public class ChequeRestService {
	
	ApplicationContext context =
	    	   new ClassPathXmlApplicationContext(new String[] {"integSoapPContext.xml"});
	
	@Autowired(required=true)
	private ChequeService chequeService = (ChequeService)context.getBean("chequeService");
	
	@POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    @Path("/obtener")
	public ConsultaChequeResponse consultarEstado(ParamConsultaChequePModel param){
		
		ConsultaChequeResponse resp = chequeService.obtenerCheque(param);
		return resp;
	}
	
}
