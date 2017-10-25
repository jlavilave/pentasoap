package cl.liberty.prodp.integ.service.validation;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.liberty.prodp.integ.commons.enums.CodigosValidacionesEnum;
import cl.liberty.prodp.integ.commons.model.ComisionPModel;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.service.utils.FechaUtil;
import cl.liberty.prodp.integ.service.utils.Propiedades;

@Component("validatorBusinessComision")
public class ValidationBusinessComision extends PentaValidatorBusiness {
	
	@Autowired(required=true)
	private Propiedades msgValid;
	
	public List<ErrorResponse> validar(ComisionPModel comision) throws IOException{
		
		List<ErrorResponse> listErr = new ArrayList<ErrorResponse>();
		BigDecimal sumMontoNeto = BigDecimal.ZERO;

		Calendar fechaActual = Calendar.getInstance();
		
		if(!super.validarRut(comision.getRutCorredor())){
			listErr.add(new ErrorResponse(CodigosValidacionesEnum.COM_BUS_RUT_CORREDOR_FORMATO.getCodigo(), 
					msgValid.getProperty(CodigosValidacionesEnum.COM_BUS_RUT_CORREDOR_FORMATO.getNombreProperty())));
		}

		sumMontoNeto = super.sumarBigDecimal(sumMontoNeto, comision.getMontoAfecto());
		sumMontoNeto = super.sumarBigDecimal(sumMontoNeto, comision.getMontoExento());
		sumMontoNeto = super.sumarBigDecimal(sumMontoNeto, comision.getMontoIva());
		
		super.comparar(comision.getMontoTotal(), sumMontoNeto, listErr, CodigosValidacionesEnum.COM_BUS_SUMA_MONTO_TOTAL);
		
		if (COD_MONEDA_CHILE.equals(comision.getMonedaPago().toUpperCase())) {
			if (super.bigDecimalEsDecimal(comision.getMontoTotal())) {
				listErr.add(new ErrorResponse(CodigosValidacionesEnum.COM_BUS_FLOTANTE_MONTO_TOTAL.getCodigo(), 
						msgValid.getProperty(CodigosValidacionesEnum.COM_BUS_FLOTANTE_MONTO_TOTAL.getNombreProperty())));
			}
			if (super.bigDecimalEsDecimal(comision.getMontoAfecto())) {
				listErr.add(new ErrorResponse(CodigosValidacionesEnum.COM_BUS_FLOTANTE_MONTO_AFECTO.getCodigo(), 
						msgValid.getProperty(CodigosValidacionesEnum.COM_BUS_FLOTANTE_MONTO_AFECTO.getNombreProperty())));			
			}
			if (super.bigDecimalEsDecimal(comision.getMontoExento())) {
				listErr.add(new ErrorResponse(CodigosValidacionesEnum.COM_BUS_FLOTANTE_MONTO_EXENTO.getCodigo(), 
						msgValid.getProperty(CodigosValidacionesEnum.COM_BUS_FLOTANTE_MONTO_EXENTO.getNombreProperty())));
			}
			if (super.bigDecimalEsDecimal(comision.getMontoIva())) {
				listErr.add(new ErrorResponse(CodigosValidacionesEnum.COM_BUS_FLOTANTE_MONTO_IVA.getCodigo(), 
						msgValid.getProperty(CodigosValidacionesEnum.COM_BUS_FLOTANTE_MONTO_IVA.getNombreProperty())));
			}
		}
		
		List<String> listMonedas = Arrays.asList(MONEDAS_VALIDAS);
		if(!listMonedas.contains(comision.getMonedaPago().toUpperCase())){
			listErr.add(new ErrorResponse(CodigosValidacionesEnum.COM_BUS_MONEDA_VALOR_DEFECTO.getCodigo(), 
					msgValid.getProperty(CodigosValidacionesEnum.COM_BUS_MONEDA_VALOR_DEFECTO.getNombreProperty())));
		}
		
		if(!super.validarStringDate(comision.getFechaMovimiento())){
			listErr.add(new ErrorResponse(CodigosValidacionesEnum.COM_BUS_FORMATO_FECHA_MOV.getCodigo(), 
					msgValid.getProperty(CodigosValidacionesEnum.COM_BUS_FORMATO_FECHA_MOV.getNombreProperty())));
		}
		
		try {
			java.util.Date fm = FechaUtil.convertStringtoUtilDate(comision.getFechaMovimiento());
			fechaActual.setTimeInMillis(fm.getTime());
			
			Integer mes = fechaActual.get(Calendar.MONTH) + 1;
			Integer annio = fechaActual.get(Calendar.YEAR);
			
			super.comparar(new BigDecimal(annio), new BigDecimal(comision.getAno()), 
					listErr, CodigosValidacionesEnum.COM_BUS_ANNIO_ACTUAL);
			
			super.comparar(new BigDecimal(mes), new BigDecimal(comision.getMes()), 
					listErr, CodigosValidacionesEnum.COM_BUS_MES_ACTUAL);
		} catch (Exception e) {
			listErr.add(new ErrorResponse(CodigosValidacionesEnum.COM_BUS_FORMATO_FECHA_MOV.getCodigo(), 
					msgValid.getProperty(CodigosValidacionesEnum.COM_BUS_FORMATO_FECHA_MOV.getNombreProperty())));
		}
		
		return listErr;
	}
	
	

}
