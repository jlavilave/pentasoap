package cl.liberty.prodp.integ.web.wsrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.liberty.prodp.integ.commons.model.ComprobanteContPModel;
import cl.liberty.prodp.integ.commons.responses.ContabilidadResponse;
import cl.liberty.prodp.integ.service.services.ContabilidadService;

@Path("/contabilidad")
public class ContabilidadRestService {

	ApplicationContext context =
	    	   new ClassPathXmlApplicationContext(new String[] {"integSoapPContext.xml"});
	
	@Autowired(required=true)
	private ContabilidadService contabilidadService = (ContabilidadService)context.getBean("contabilidadService");
	
	@POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    @Path("/registrar")
	public ContabilidadResponse registrarContabilidad(ComprobanteContPModel c){
		
		ContabilidadResponse resp = contabilidadService.registrar(c);
		return resp;
	}
	
}
