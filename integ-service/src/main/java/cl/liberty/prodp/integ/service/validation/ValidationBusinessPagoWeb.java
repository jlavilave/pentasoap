package cl.liberty.prodp.integ.service.validation;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.liberty.prodp.integ.commons.enums.CodigosValidacionesEnum;
import cl.liberty.prodp.integ.commons.model.DetallePagoWebPModel;
import cl.liberty.prodp.integ.commons.model.PagoWebPModel;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.service.utils.Propiedades;

@Component("validationBusinessPagoWeb")
public class ValidationBusinessPagoWeb extends PentaValidatorBusiness {

	@Autowired(required=true)
	private Propiedades msgValid;
	
	public List<ErrorResponse> validar(PagoWebPModel pw) throws IOException{
		
		List<ErrorResponse> listErr = new ArrayList<ErrorResponse>();
		
		super.validarMonedaCLP(pw.getMonOrigen(), listErr, CodigosValidacionesEnum.PW_VALOR_DEFECTO_MONEDA);
		
		//Pendiente de validacion
		if(!super.validarRut(String.valueOf(pw.getRutCliente()).concat(pw.getDvRutCliente()))){
			listErr.add(new ErrorResponse(CodigosValidacionesEnum.PW_DV_CLIENTE.getCodigo(), 
					msgValid.getProperty(CodigosValidacionesEnum.PW_DV_CLIENTE.getNombreProperty())));
		}
		
		//valdiacion Formato
		super.validarRango(new BigDecimal(pw.getFormatoPago()), BigDecimal.ZERO, 
				new BigDecimal("17"), listErr, CodigosValidacionesEnum.PW_VALOR_FORMATO_PAGO);
		
		//valdiacion codigo ingreso
		super.validarRango(new BigDecimal(pw.getCodigoIngreso()), BigDecimal.ZERO, 
				new BigDecimal("4"), listErr, CodigosValidacionesEnum.PW_VALOR_CODIGO_INGRESO);
		
		listErr.addAll(validarSumatorias(pw));
		
		
		if (!super.validarStringTimestamp(pw.getFechaAviso())) {
			listErr.add(new ErrorResponse(CodigosValidacionesEnum.PW_FORMATO_FECHA_AVISO.getCodigo(), 
					msgValid.getProperty(CodigosValidacionesEnum.PW_FORMATO_FECHA_AVISO.getNombreProperty())));
		}
		
		return listErr;
	}
	
	
	public List<ErrorResponse> validarSumatorias(PagoWebPModel pw) throws IOException{
		
		List<ErrorResponse> listErr = new ArrayList<ErrorResponse>();
		BigDecimal mSumTotal = BigDecimal.ZERO;
		BigDecimal mSumAfecto = BigDecimal.ZERO;
		BigDecimal mSumExento = BigDecimal.ZERO;
		BigDecimal mSumIva = BigDecimal.ZERO;
		BigDecimal mSumCabecera = BigDecimal.ZERO;
		BigDecimal mSumDetalle = BigDecimal.ZERO;
		
		mSumCabecera = super.sumarBigDecimal(pw.getmTotalAfecto(),pw.getmTotalExento());
		mSumCabecera = super.sumarBigDecimal(mSumCabecera,pw.getmTotalIva());
		
		super.comparar(pw.getMontoTotal(), mSumCabecera, listErr, CodigosValidacionesEnum.PW_SUMATORIA_TOTAL_CABECERA);
		
		if(pw.getDetalles() != null && pw.getDetalles().length != 0){
			for (DetallePagoWebPModel detalle : pw.getDetalles()) {
				mSumTotal = super.sumarBigDecimal(mSumTotal,detalle.getMontoTotalOperacion());
				mSumAfecto = super.sumarBigDecimal(mSumAfecto,detalle.getMontoAfecto());
				mSumExento = super.sumarBigDecimal(mSumExento,detalle.getMontoExento());
				mSumIva = super.sumarBigDecimal(mSumIva,detalle.getMontoIva());
				
				mSumDetalle = super.sumarBigDecimal(detalle.getMontoAfecto(),detalle.getMontoExento());
				mSumDetalle = super.sumarBigDecimal(mSumDetalle,detalle.getMontoIva());
				
				super.comparar(detalle.getMontoTotalOperacion(), mSumDetalle, listErr, CodigosValidacionesEnum.PW_SUMATORIA_TOTAL_DETALLE);
				
				mSumDetalle = BigDecimal.ZERO;
			}
		
			super.comparar(pw.getMontoTotal(), mSumTotal, listErr, CodigosValidacionesEnum.PW_SUMATORIA_MONTO_TOTAL);
			super.comparar(pw.getmTotalAfecto(), mSumAfecto, listErr, CodigosValidacionesEnum.PW_SUMATORIA_TOTAL_AFECTO);
			super.comparar(pw.getmTotalExento(), mSumExento, listErr, CodigosValidacionesEnum.PW_SUMATORIA_TOTAL_EXENTO);
			super.comparar(pw.getmTotalIva(), mSumIva, listErr, CodigosValidacionesEnum.PW_SUMATORIA_TOTAL_IVA);
		}
		return listErr;
	}
	
}
