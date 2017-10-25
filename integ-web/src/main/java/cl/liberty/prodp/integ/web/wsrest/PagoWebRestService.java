package cl.liberty.prodp.integ.web.wsrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.liberty.prodp.integ.commons.model.PagoWebPModel;
import cl.liberty.prodp.integ.commons.responses.PagoWebResponse;
import cl.liberty.prodp.integ.service.services.PagoWebService;

@Path("/pagoweb")
public class PagoWebRestService {

	ApplicationContext context =
	    	   new ClassPathXmlApplicationContext(new String[] {"integSoapPContext.xml"});
	
	@Autowired(required=true)
	private PagoWebService pagoWebService = (PagoWebService)context.getBean("pagoWebService");
	
	@POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    @Path("/registrar")
	public PagoWebResponse registrarPagoWeb(PagoWebPModel pagoWeb){
		
		PagoWebResponse resp = pagoWebService.registrarPagoWeb(pagoWeb);

		return resp;
	}
	
}
