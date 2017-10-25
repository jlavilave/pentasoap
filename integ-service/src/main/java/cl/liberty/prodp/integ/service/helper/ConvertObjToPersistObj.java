package cl.liberty.prodp.integ.service.helper;

import org.springframework.stereotype.Component;

import cl.liberty.prodp.integ.commons.model.AvisoPModel;
import cl.liberty.prodp.integ.commons.model.PagoWebPModel;
import cl.liberty.prodp.integ.commons.model.ParamConsultaChequePModel;
import cl.liberty.prodp.integ.commons.model.ParamConsultaEstadoPModel;
import cl.liberty.prodp.integ.commons.model.PersistenciaPModel;
import cl.liberty.prodp.integ.commons.model.SolicitudPagoPModel;

@Component("convertObjToPersistObj")
public class ConvertObjToPersistObj {
	
	public PersistenciaPModel getObj(ParamConsultaChequePModel param, String xml){
		
		PersistenciaPModel p = new PersistenciaPModel();

		p.setNombreUsuario(param.getNombreUsuario());
		p.setOrigen(param.getCodigoOrigen());
		p.setLlaveRegistro(String.valueOf(param.getNumeroLiquidacion())
				.concat("-").concat(String.valueOf(param.getNumeroSiniestro())));
		p.setTipoSist("Sistema SOAP Penta");
		p.setNombreWs("chequeService");
		p.setNombreFuncionWs("obtenerCheque");
		p.setObjEntrada(xml);
		
		return p;
	}
	
	public PersistenciaPModel getObjPersistencia(AvisoPModel a, String entrada){
		
		PersistenciaPModel p = new PersistenciaPModel();
		p.setNombreUsuario(a.getNombreUsuario());
		p.setOrigen(a.getOrigen());
		p.setTipoSist("Sistema SOAP Penta");
		p.setNombreWs("avisoService");
		p.setNombreFuncionWs("registrarAviso");
		p.setObjEntrada(entrada);

		return p;
	}
	
	public PersistenciaPModel getObjPersistencia(ParamConsultaEstadoPModel param, String entrada){
		
		PersistenciaPModel p = new PersistenciaPModel();
		p.setNombreUsuario(param.getNombreUsuario());
		p.setOrigen(param.getCodigoOrigen());
		p.setLlaveRegistro(String.valueOf(param.getNumeroAviso()));
		p.setTipoSist("Sistema SOAP Penta");
		p.setNombreWs("avisoService");
		p.setNombreFuncionWs("obtenerEstadoAviso");
		p.setObjEntrada(entrada);

		return p;
	}
	
	public PersistenciaPModel getObjPersistencia(SolicitudPagoPModel solPago, String entrada){
		
		PersistenciaPModel p = new PersistenciaPModel();
		p.setNombreUsuario(solPago.getNombreUsuario());
		p.setLlaveRegistro(String.valueOf(solPago.getNumSiniestro()));
		p.setTipoSist("Sistema SOAP Penta");
		p.setNombreWs("SolicitudPagoService");
		p.setNombreFuncionWs("registrarSolicitudPago");
		p.setObjEntrada(entrada);

		return p;
	}
	
	
	public PersistenciaPModel getObjPersistencia(PagoWebPModel pw, String entrada){
		
		PersistenciaPModel p = new PersistenciaPModel();
		p.setNombreUsuario(pw.getNombreUsuario());
		p.setTipoSist("Sistema SOAP Penta");
		p.setNombreWs("PagoWebService");
		p.setNombreFuncionWs("registrarPagoWeb");
		p.setObjEntrada(entrada);

		return p;
	}

}
