package cl.liberty.prodp.integ.web.wsrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.liberty.prodp.integ.commons.model.SolicitudPagoPModel;
import cl.liberty.prodp.integ.commons.responses.SolicitudPagoRegResponse;
import cl.liberty.prodp.integ.service.services.SolicitudPagoService;

@Path("/solicitudpago")
public class SolicitudPagoRestService {

	ApplicationContext context =
	    	   new ClassPathXmlApplicationContext(new String[] {"integSoapPContext.xml"});
	
	@Autowired(required=true)
	private SolicitudPagoService solicitudPagoService = (SolicitudPagoService)
		context.getBean("solicitudPagoService");
	
	@POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    @Path("/registrar")
	public SolicitudPagoRegResponse registrarSolicitudPago(SolicitudPagoPModel solPago){
		
		SolicitudPagoRegResponse resp = solicitudPagoService.registrarSolicitudPago(solPago);
		return resp;
	}
	
}
