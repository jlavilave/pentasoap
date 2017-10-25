package cl.liberty.prodp.integ.service.validation;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.liberty.prodp.integ.commons.enums.CodigosValidacionesEnum;
import cl.liberty.prodp.integ.commons.model.AvisoPModel;
import cl.liberty.prodp.integ.commons.model.DetalleAvisoPModel;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.service.utils.Propiedades;

@Component("validatorBusinessAviso")
public class ValidatorBusinessAviso extends PentaValidatorBusiness {
	
	@Autowired(required=true)
	private Propiedades msgValid;
	
	public List<ErrorResponse> validar(AvisoPModel aviso) throws IOException{
		
		List<ErrorResponse> listErr = new ArrayList<ErrorResponse>();
		BigDecimal mSumRendicion = BigDecimal.ZERO;
		BigDecimal mSumAfecto = BigDecimal.ZERO;
		BigDecimal mSumExento = BigDecimal.ZERO;
		BigDecimal mSumIva = BigDecimal.ZERO;
		BigDecimal mSumCabecera = BigDecimal.ZERO;
		BigDecimal mSumDetalle = BigDecimal.ZERO;
		
		
		if (aviso != null) {

			super.validarMonedaCLP(aviso.getMonOrigen(), listErr, CodigosValidacionesEnum.AV_VALOR_DEFECTO_MONEDA);
			
			mSumCabecera = super.sumarBigDecimal(aviso.getmTotalAfecto(),aviso.getmTotalExento());
			mSumCabecera = super.sumarBigDecimal(mSumCabecera,aviso.getmTotalIva());
			mSumCabecera = super.sumarBigDecimal(mSumCabecera,aviso.getOtrosGastos());
			
			super.comparar(aviso.getmTotalRendicion(), mSumCabecera, listErr, CodigosValidacionesEnum.SUMATORIA_01);
			
			if(aviso.getDetalles() != null && aviso.getDetalles().length != 0){
				for (DetalleAvisoPModel detalle : aviso.getDetalles()) {
					
					mSumRendicion = super.sumarBigDecimal(mSumRendicion,detalle.getmRendicion());
					mSumAfecto = super.sumarBigDecimal(mSumAfecto,detalle.getmAfecto());
					mSumExento = super.sumarBigDecimal(mSumExento,detalle.getmExento());
					mSumIva = super.sumarBigDecimal(mSumIva,detalle.getmIva());
					
					mSumDetalle = super.sumarBigDecimal(detalle.getmAfecto(),detalle.getmExento());
					mSumDetalle = super.sumarBigDecimal(mSumDetalle,detalle.getmIva());
					
					super.comparar(detalle, mSumDetalle, listErr, CodigosValidacionesEnum.SUMATORIA_06);
					
					mSumDetalle = BigDecimal.ZERO;
				}
				
				mSumRendicion = super.sumarBigDecimal(mSumRendicion,aviso.getOtrosGastos());
				
				super.comparar(aviso.getmTotalRendicion(), mSumRendicion, listErr, CodigosValidacionesEnum.SUMATORIA_02);
				super.comparar(aviso.getmTotalAfecto(), mSumAfecto, listErr, CodigosValidacionesEnum.SUMATORIA_03);
				super.comparar(aviso.getmTotalExento(), mSumExento, listErr, CodigosValidacionesEnum.SUMATORIA_04);
				super.comparar(aviso.getmTotalIva(), mSumIva, listErr, CodigosValidacionesEnum.SUMATORIA_05);
			}
			
			if (!super.validarStringTimestamp(aviso.getFechaVencimiento())) {
				listErr.add(new ErrorResponse(CodigosValidacionesEnum.AV_FORMATO_FECHA_AVISO.getCodigo(), 
						msgValid.getProperty(CodigosValidacionesEnum.AV_FORMATO_FECHA_AVISO.getNombreProperty())));
			}
		}
		
		return listErr;
	}
}
