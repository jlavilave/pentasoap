package cl.liberty.prodp.integ.web.wsrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.liberty.prodp.integ.commons.model.AvisoPModel;
import cl.liberty.prodp.integ.commons.model.ParamConsultaEstadoPModel;
import cl.liberty.prodp.integ.commons.responses.AvisoRegResponse;
import cl.liberty.prodp.integ.commons.responses.ConsultaEstadoResponse;
import cl.liberty.prodp.integ.service.services.AvisoService;

@Path("/aviso")
public class AvisoRestService {
	
	ApplicationContext context =
	    	   new ClassPathXmlApplicationContext(new String[] {"integSoapPContext.xml"});
	
	@Autowired(required=true)
	private AvisoService avisoService = (AvisoService)context.getBean("avisoService");
	
	@POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    @Path("/registrar")
	public AvisoRegResponse registrarAviso(AvisoPModel aviso){
		
		AvisoRegResponse resp = avisoService.registrarAviso(aviso);
		return resp;
	}
	
	
	@POST
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    @Path("/consultar/estado")
	public ConsultaEstadoResponse consultarEstado(ParamConsultaEstadoPModel param){
		
		ConsultaEstadoResponse resp = avisoService.obtenerEstadoAviso(param);
		return resp;
	}
	
}
