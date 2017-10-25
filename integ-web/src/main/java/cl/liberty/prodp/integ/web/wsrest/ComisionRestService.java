package cl.liberty.prodp.integ.web.wsrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.liberty.prodp.integ.commons.model.ComisionPModel;
import cl.liberty.prodp.integ.commons.responses.ComisionRegResponse;
import cl.liberty.prodp.integ.service.services.ComisionService;

@Path("/comision")
public class ComisionRestService {
	
	ApplicationContext context =
	    	   new ClassPathXmlApplicationContext(new String[] {"integSoapPContext.xml"});

	@Autowired(required=true)
	private ComisionService comisionService = (ComisionService)context.getBean("comisionService");
	
	@POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    @Path("/registrar")
	public ComisionRegResponse registrarComision(ComisionPModel comision){
		
		ComisionRegResponse resp = comisionService.registrarComision(comision);
		return resp;
	}
}
