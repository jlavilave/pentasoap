package cl.liberty.prodp.integ.service.validation;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.liberty.prodp.integ.commons.enums.CodigosValidacionesEnum;
import cl.liberty.prodp.integ.commons.model.DocTributariosPModel;
import cl.liberty.prodp.integ.commons.model.SolicitudPagoPModel;
import cl.liberty.prodp.integ.commons.responses.ErrorResponse;
import cl.liberty.prodp.integ.service.utils.Propiedades;

@Component("validatorBusinessSolPago")
public class ValidatorBusinessSolPago extends PentaValidatorBusiness {

	private static final Integer LARGO_PERIODO = 6;
	private static final String TIPO_BENEFICIARIO_P = "P";
	private static final String TIPO_BENEFICIARIO_A = "A";
	private static final String ESTADO_INGRESADO = "I";
	private static final String[] TIPOS_REGISTROS = {"F", "B", "I"};
	private static final String[] VALORES_RECUPERA_IVA = {"0","1"};
	private static final String[] TIPOS_DOC_PARA_BENEF_A = {"0","2","4","6","8","13"};
	private static final String[] TIPOS_DOC_PARA_BENEF_P = {"3","7"};
	private static final Integer CODIGO_MONEDA_CL = 1;
	
	@Autowired(required=true)
	private Propiedades msgValid;

	public List<ErrorResponse> validar(SolicitudPagoPModel solPago) throws IOException{
		
		List<ErrorResponse> listErr = new ArrayList<ErrorResponse>();
		BigDecimal sumMontoNeto = BigDecimal.ZERO;
		BigDecimal sumMontoImpuesto = BigDecimal.ZERO;
		String td, tb, tr;
		BigDecimal mi = BigDecimal.ZERO;
		BigDecimal porImpuesto;
		BigDecimal piInf;
		BigDecimal piSup;
		
		this.validarLargoInteger(solPago.getPeriodo(), LARGO_PERIODO, 
				listErr, CodigosValidacionesEnum.LARGO_PERIODO);
		
		if(solPago.getTipoDocumento() != null && solPago.getTipoDocumento() == TIPO_DOC_RUT){
			super.validarRut(solPago.getRutBeneficiario(), 
					listErr, CodigosValidacionesEnum.FORMATO_BENEFICIARIO);
		}
		
		if(!ESTADO_INGRESADO.equals(solPago.getEstado())){
			listErr.add(new ErrorResponse(CodigosValidacionesEnum.ESTADO_INGRESADO.getCodigo(), 
					msgValid.getProperty(CodigosValidacionesEnum.ESTADO_INGRESADO.getNombreProperty())));
		}
		if(solPago.getFormaPago() != null){
			listErr.add(new ErrorResponse(CodigosValidacionesEnum.FORMA_PAGO_NO_NULL.getCodigo(), 
					msgValid.getProperty(CodigosValidacionesEnum.FORMA_PAGO_NO_NULL.getNombreProperty())));
		}
		
		for (DocTributariosPModel doc : solPago.getDocumentos()) {
			td = doc.getTipoDocumento();
			tb = doc.getTipoBeneficiario();
			tr = doc.getTipoRegistro();
			mi = doc.getMontoImpuesto();
			Integer tDoc = Integer.valueOf(doc.getTipoDocumento());
			sumMontoNeto = sumMontoNeto.add(doc.getMontoNeto());
			sumMontoImpuesto = sumMontoImpuesto.add(doc.getMontoImpuesto());
			
			super.validarRango(new BigDecimal(tDoc), BigDecimal.ZERO, new BigDecimal(13L), listErr, CodigosValidacionesEnum.RANGO_TIPO_DOC);
			
			super.indexOf(TIPOS_REGISTROS, tr, listErr, CodigosValidacionesEnum.TIPO_REGISTRO_VALIDO);
			super.indexOf(VALORES_RECUPERA_IVA, doc.getRecuperaIva(), listErr, CodigosValidacionesEnum.RECUPERA_IVA_VALIDO);
			
			super.comparar(td, TIPOS_DOC_PARA_BENEF_A, tb, TIPO_BENEFICIARIO_A, listErr, CodigosValidacionesEnum.TIPO_BENEFICIARIO_1, doc.getNumDocumento());
			super.comparar(td, TIPOS_DOC_PARA_BENEF_P, tb, TIPO_BENEFICIARIO_P, listErr, CodigosValidacionesEnum.TIPO_BENEFICIARIO_2, doc.getNumDocumento());

			if("F".equals(tr) && "1".equals(td)) {
				porImpuesto = BigDecimal.ZERO;
				piInf = BigDecimal.ZERO;
				piSup = BigDecimal.ZERO;
				porImpuesto = calcularPorcentajeMontoNeto(mi, new BigDecimal(19));
				piSup = porImpuesto.add(new BigDecimal(5));
				piInf = porImpuesto.add(new BigDecimal(-5));
				
				super.validarRango(porImpuesto, piInf, piSup, listErr, CodigosValidacionesEnum.MONTO_IMPUESTO_1, doc.getNumDocumento());
			}

			super.comparar("F", tr, "2", td, mi,listErr, CodigosValidacionesEnum.MONTO_IMPUESTO_2, doc.getNumDocumento());
			super.comparar("B", tr, "4", td, mi,listErr, CodigosValidacionesEnum.MONTO_IMPUESTO_3, doc.getNumDocumento());
			
			
			if("B".equals(tr) && "3".equals(td)) {
				porImpuesto = BigDecimal.ZERO;
				piInf = BigDecimal.ZERO;
				piSup = BigDecimal.ZERO;
				porImpuesto = (new BigDecimal(-1)).multiply(calcularPorcentajeMontoNeto(mi, new BigDecimal(10)));
				piSup = porImpuesto.add(new BigDecimal(5));
				piInf = porImpuesto.add(new BigDecimal(-5));
				
				super.validarRango(porImpuesto, piInf, piSup, listErr, CodigosValidacionesEnum.MONTO_IMPUESTO_4, doc.getNumDocumento());
			}
			super.comparar("I", tr, mi,listErr, CodigosValidacionesEnum.MONTO_IMPUESTO_3, doc.getNumDocumento());
		}
		

		super.comparar(solPago.getMontoTotalNeto(), sumMontoNeto, listErr, CodigosValidacionesEnum.MONTO_TOTAL_NETO);
		super.comparar(solPago.getMontoTotalImpuesto(), sumMontoImpuesto, listErr, CodigosValidacionesEnum.MONTO_TOTAL_IMPUESTO);
		
		this.validarMonedaPago(solPago.getMonedaPago(), listErr, CodigosValidacionesEnum.MONEDA_PAGO);
		
		super.validarFechaCorta(solPago.getFechaPago(), listErr, CodigosValidacionesEnum.FORMATO_FECHA_PAGO);
		super.validarFechaCorta(solPago.getFechaTipoCambio(), listErr, CodigosValidacionesEnum.FORMATO_FECHA_TIPO_CAMBIO);
		super.validarFechaCorta(solPago.getFechaProceso(), listErr, CodigosValidacionesEnum.FORMATO_FECHA_PROCESO);
		super.validarFechaCorta(solPago.getFechaTraspaso(), listErr, CodigosValidacionesEnum.FORMATO_FECHA_TRASPASO);
		
		
		return  listErr;
	}
	
	
	private BigDecimal calcularPorcentajeMontoNeto(BigDecimal montoNeto, BigDecimal porcentaje){
		
		BigDecimal porReal = porcentaje.divide(new BigDecimal(100), 2, RoundingMode.CEILING);
		BigDecimal val = montoNeto.multiply(porReal);
		val = val.setScale(0, BigDecimal.ROUND_HALF_UP);
		return val;
	}
	
	private void validarMonedaPago(Integer moneda, List<ErrorResponse> list, 
			CodigosValidacionesEnum e)throws IOException{
		
		if (CODIGO_MONEDA_CL != moneda) {
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty())));
		}
	}
	
	private void validarLargoInteger(Integer periodo, Integer largo, 
			List<ErrorResponse> list, CodigosValidacionesEnum e) throws IOException{
		
		if (periodo != null && String.valueOf(periodo).length() != largo) {
			list.add(new ErrorResponse(e.getCodigo(), msgValid.getProperty(e.getNombreProperty())));
		}
	}
}
