package cl.liberty.prodp.integ.commons.enums;

public enum CodigosValidacionesEnum {

	//Códigos para servicios de rendicion
	//************************************************************
	NULO_MTOTAL_RENDICION		("111003", "valid.integ.nulo.mtotal.rendicion"),
	NEGATIVO_MTOTAL_RENDICION	("111004", "valid.integ.negativo.mtotal.rendicion"),
	NULO_MTOTAL_AFECTO			("111005", "valid.integ.nulo.mtotal.afecto"),
	NEGATIVO_MTOTAL_AFECTO		("111006", "valid.integ.negativo.mtotal.afecto"),
	NULO_MTOTAL_EXENTO			("111007", "valid.integ.nulo.mtotal.exento"),
	NEGATIVO_MTOTAL_EXENTO		("111008", "valid.integ.negativo.mtotal.exento"),
	NULO_MTOTAL_IVA				("111009", "valid.integ.nulo.mtotal.iva"),
	NEGATIVO_MTOTAL_IVA			("111010", "valid.integ.negativo.mtotal.iva"),
	NULO_OTROS_GASTOS			("111011", "valid.integ.nulo.otros.gastos"),
	NEGATIVO_OTROS_GASTOS		("111012", "valid.integ.negativo.otros.gastos"),
	NULO_ORIGEN					("111013", "valid.integ.nulo.origen"),
	NULO_TIPO_MOV				("111014", "valid.integ.nulo.tipo.mov"),
	NULO_FECHA_VENCIMIENTO		("111015", "valid.integ.nulo.fecha.vencimiento"),
	NULO_MONEDA_ORIGEN			("111016", "valid.integ.nulo.moneda.origen"),
	LARGO_MONEDA_ORIGEN			("111017", "valid.integ.largo.moneda.origen"),
	LARGO_NOMBRE				("111018", "valid.integ.largo.nombre"),
	LARGO_DIRECCION				("111019", "valid.integ.largo.direccion"),
	LARGO_COMUNA				("111020", "valid.integ.largo.comuna"),
	LARGO_CIUDAD				("111021", "valid.integ.largo.ciudad"),
	NULO_MONTO_RENDICION		("111022", "valid.integ.nulo.monto.rendicion"),
	NEGATIVO_MONTO_RENDICION	("111023", "valid.integ.negativo.monto.rendicion"),
	NULO_MONTO_AFECTO			("111024", "valid.integ.nulo.monto.afecto"),
	NEGATIVO_MONTO_AFECTO		("111025", "valid.integ.negativo.monto.afecto"),
	NULO_MONTO_EXENTO			("111026", "valid.integ.nulo.monto.exento"),
	NEGATIVO_MONTO_EXENTO		("111027", "valid.integ.negativo.monto.exento"),
	NULO_MONTO_IVA				("111028", "valid.integ.nulo.monto.iva"),
	NEGATIVO_MONTO_IVA			("111029", "valid.integ.negativo.monto.iva"),
	NULO_NUM_REFERENCIA			("111030", "valid.integ.nulo.num.referencia"),
	NEGATIVO_NUM_REFERENCIA		("111031", "valid.integ.negativo.num.referencia"),
	VACIO_DETALLES				("111044", "valid.integ.vacio.detalles"),
	NULO_NOMBRE_USUARIO_REND	("111043", "valid.integ.nulo.nombre.usuario.rend"),
	
	//códigos de sumatorias
	SUMATORIA_01		("111032", "valid.business.sum.cabecera"),  
	SUMATORIA_02		("111033", "valid.business.sum.rendicion"),
	SUMATORIA_03		("111034", "valid.business.sum.total.afecto"),
	SUMATORIA_04		("111035", "valid.business.sum.total.exento"),
	SUMATORIA_05		("111036", "valid.business.sum.total.iva"),
	SUMATORIA_06		("111037", "valid.business.sum.detalle"),
	
	//nuevos códigos de error 
	N_AVISO_NULO				("112003", "valid.integ.nulo.numaviso"),
	N_AVISO_NEGATIVO			("112004", "valid.integ.negativo.numaviso"),
	NULO_NOMBRE_USUARIO_CEST	("112005", "valid.integ.nulo.nombre.usuario"),
	
	//Nuevo para rendiciones
	LARGO_NOMBRE_USUARIO_REND	("111042", "valid.integ.largo.nombre.usuario.rend"),
	AV_FORMATO_FECHA_AVISO		("111045", "valid.business.formato.fecha.aviso.av"),
	
	AV_VALOR_DEFECTO_MONEDA		("111046", "valid.business.valor.default.moneda.av"),
	
	//Códigos para servicios de siniestros
	//************************************************************
	TIPO_BENEFICIARIO_1	("211049", "valid.business.tipo.beneficiario1"),
	TIPO_BENEFICIARIO_2	("211050", "valid.business.tipo.beneficiario2"),
	MONTO_IMPUESTO_1 	("211051", "valid.business.monto.impuesto1"),
	MONTO_IMPUESTO_2	("211052", "valid.business.monto.impuesto2"),
	MONTO_IMPUESTO_3	("211053", "valid.business.monto.impuesto3"),
	MONTO_IMPUESTO_4	("211054", "valid.business.monto.impuesto4"),
	MONTO_IMPUESTO_5	("211055", "valid.business.monto.impuesto5"),
	
	FORMATO_PERIODO			("211037", "valid.business.formato.periodo"),
	FORMATO_BENEFICIARIO	("211038", "valid.business.formato.beneficiario"),
	TIPO_BENEFICIARIO		("211039", "valid.business.tipo.beneficiario"),
	MONEDA_PAGO				("211040", "valid.business.moneda.pago"),
	ESTADO_INGRESADO		("211041", "valid.business.estado.ingresado"),
	MONTO_TOTAL_NETO		("211042", "valid.business.monto.total.neto"),
	MONTO_TOTAL_IMPUESTO	("211043", "valid.business.monto.total.impuesto"),
	FORMA_PAGO_NO_NULL		("211044", "valid.business.forma.pag.no.null"),
	RANGO_TIPO_DOC			("211046", "valid.business.tipo.doc.rango"),
	TIPO_REGISTRO_VALIDO	("211047", "valid.business.tipo.registro.valido"),
	RECUPERA_IVA_VALIDO		("211048", "valid.business.recupera.iva.valido"),
	
	STR_VACIO_NUM_DOCUMENTO	("211025","valid.integ.strvacio.num.documento"),
	NULO_NUM_DOCUMENTO		("211026","valid.integ.nulo.num.documento"),
	NULO_MONTO_NETO			("211027","valid.integ.nulo.monto.neto"),
	NEGATIVO_MONTO_NETO		("211028","valid.integ.neg.monto.neto"),
	NULO_FECHA_DOCUMENTO	("211029","valid.integ.nulo.fecha.documento"),
	NULO_TIPO_DOCUMENTO		("211031","valid.integ.nulo.tipo.documento"),
	NULO_TIPO_REGISTRO		("211032","valid.integ.nulo.tipo.registro"),
	NULO_TIPO_BENEFICIARIO	("211034","valid.integ.nulo.beneficiario"),
	
	LARGO_PERIODO				("211003", "valid.integ.largo.periodo"),
	NULO_NUM_SINIESTRO			("211005", "valid.integ.nulo.num.siniestro"),
	NEG_NUM_SINIESTRO			("211006", "valid.integ.neg.num.siniestro"),
	NULO_NUM_LIQUIDACION		("211008", "valid.integ.nulo.num.liquidacion"),
	NEG_NUM_LIQUIDACION			("211009", "valid.integ.neg.num.liquidacion"),
	NULO_FECHA_PAGO				("211010", "valid.integ.nulo.fecha.pago"),
	NULO_NOMBRE_BENEFICIARIO	("211011", "valid.integ.nulo.nombre.beneficiario"),
	NULO_RUT_BENEFICIARIO		("211015", "valid.integ.nulo.rut.beneficiario"),
	NO_NULO_FECHA_TRASPASO		("211017", "valid.integ.no.nulo.fecha.traspaso"),
	NULO_MONTO_TOTAL_NETO		("211018", "valid.integ.nulo.monto.total.neto"),
	NEG_MONTO_TOTAL_NETO		("211019", "valid.integ.neg.monto.total.neto"),
	NULO_MONTO_TOTAL_IMPUESTO	("211020", "valid.integ.nulo.monto.total.impuesto"),
	NULO_NOMBRE_USUARIO			("211021", "valid.integ.nulo.nombre.usuario"),
	LARGO_NOMBRE_BENEFICIARIO	("211012", "valid.integ.largo.nombre.beneficiario"),
	LARGO_RUT_BENEFICIARIO		("211016", "valid.integ.largo.rut.beneficiario"),
	LARGO_TIPO_DOCUMENTO		("211030", "valid.integ.largo.tipo.documento"),
	LARGO_TIPO_BENEFICIARIO		("211036", "valid.integ.largo.tipo.beneficiario"),
	LARGO_TIPO_REGISTRO_SOLPAGO	("211033", "valid.integ.largo.tipo.registro.solpago"),
	
	//codigos Nuevos para servicio solicitud pago 	
	LARGO_MONEDA_PAGO			("211062", "valid.integ.largo.moneda.pago"),	
	NULO_MONEDA_PAGO			("211063", "valid.integ.nulo.moneda.pago"), 
	NULO_FECHA_PROCESO			("211064", "valid.integ.nulo.fecha.proceso"),
	NULO_ESTADO					("211065", "valid.integ.nulo.estado"),
	LARGO_ESTADO				("211066", "valid.integ.largo.estado"),
	NULO_ORIGEN_SOL_PAGO		("211067", "valid.integ.nulo.origen.solpago"),
	NULO_LISTADO_DOCS			("211068", "valid.integ.nulo.listado.docs"),
	LARGO_FORMA_PAGO			("211069", "valid.integ.largo.forma.pago"),
	NULO_MONEDA_SINIESTRO		("211073", "valid.integ.nulo.moneda.siniestro"),
	LARGO_MONEDA_SINIESTRO		("211074", "valid.integ.largo.moneda.siniestro"),
	NULO_RECUPERA_IVA			("211075", "valid.integ.nulo.recupera.iva"),
	LARGO_RECUPERA_IVA			("211076", "valid.integ.largo.recupera.iva"),
	NULO_MONTO_IMPUESTO			("211077", "valid.integ.nulo.monto.impuesto"),
	STR_VACIO_NOMBRE_USUARIO	("211070", "valid.integ.strvacio.nombre.usuario"),
	
	FORMATO_FECHA_PAGO			("211078", "valid.business.formato.fecha.pago"),
	FORMATO_FECHA_TIPO_CAMBIO	("211079", "valid.business.formato.fecha.tipo.cambio"),
	FORMATO_FECHA_PROCESO		("211080", "valid.business.formato.fecha.proceso"),
	FORMATO_FECHA_TRASPASO		("211081", "valid.business.formato.fecha.traspaso"),
	
	
	//Servicio busqueda cheque
	FORMATO_RUT_BENEF_CHK		("213019", "valid.business.formato.rut.benef.chk"),
	NULO_NUM_SINIESTRO_CHK		("213005", "valid.integ.nulo.num.siniestro.chk"),
	NEGATIVO_NUM_SINIESTRO_CHK	("213006", "valid.integ.negativo.num.siniestro.chk"),
	NULO_NUM_LIQ_CHK			("213008", "valid.integ.nulo.num.liq.chk"),
	NEGATIVO_NUM_LIQ_CHK		("213009", "valid.integ.negativo.num.liq.chk"),
	NULO_RUT_BENEFICIARIO_CHK	("213012", "valid.integ.nulo.rut.beneficiario.chk"),
	NULO_NOMBRE_USUARIO_CHK		("213015", "valid.integ.nulo.nombre.usuario.chk"),
	LARGO_RUT_BENEFICIARIO_CHK	("213011", "valid.integ.largo.rut.benef.chk"),
	LARGO_NOMBRE_USUARIO_CHK	("213014", "valid.integ.largo.nombre.usuario.chk"),
	NULO_CODIGO_ORIGEN_CHK		("213010", "valid.integ.nulo.cod.origen.chk"),
	
	
	
	//Servicio registro pago web
	PW_FORMATO_FECHA_AVISO		("311062", "valid.business.formato.fecha.aviso.pw"),
	
	PW_VALOR_DEFECTO_MONEDA		("311063", "valid.business.valor.default.moneda.pw"),
	PW_SUMATORIA_TOTAL_EXENTO	("311064", "valid.business.sum.total.exento.pw"),
	PW_SUMATORIA_TOTAL_AFECTO	("311065", "valid.business.sum.total.afecto.pw"),
	PW_SUMATORIA_TOTAL_IVA		("311066", "valid.business.sum.total.iva.pw"),
	PW_SUMATORIA_MONTO_TOTAL	("311067", "valid.business.sum.monto.total.pw"),
	PW_SUMATORIA_TOTAL_CABECERA	("311068", "valid.business.sum.total.cabecera.pw"),
	PW_DV_CLIENTE				("311069", "valid.business.dv.cliente.pw"),
	PW_VALOR_FORMATO_PAGO		("311070", "valid.business.valor.formato.pago.pw"),
	PW_VALOR_CODIGO_INGRESO		("311071", "valid.business.valor.cod.ingreso.pw"),
	PW_VALOR_DEFAULT_TIPOMOV	("311072", "valid.business.valor.default.tipomov.pw"),
	PW_SUMATORIA_TOTAL_DETALLE	("311073", "valid.business.sum.total.det.pw"),
		
	//Servicio registro pago web (Cabecera)
	PW_NULO_FECHA_AVISO			("311003", "valid.integ.nulo.fecha.aviso.pw"),
	PW_NULO_MONEDA				("311005", "valid.integ.nulo.moneda.pw"),
	PW_STR_VACIO_MONEDA		 	("311006", "valid.integ.strvacio.moneda.pw"),
	PW_NULO_TOTAL_EXENTO		("311007", "valid.integ.nulo.total.exento.pw"),
	PW_NEGATIVO_TOTAL_EXENTO	("311008", "valid.integ.negativo.total.exento.pw"),
	PW_NULO_TOTAL_AFECTO		("311009", "valid.integ.nulo.total.afecto.pw"),
	PW_NEGATIVO_TOTAL_AFECTO	("311010", "valid.integ.negativo.total.afecto.pw"),
	PW_NULO_TOTAL_IVA			("311011", "valid.integ.nulo.total.iva.pw"),
	PW_NEGATIVO_TOTAL_IVA		("311012", "valid.integ.negativo.total.iva.pw"),
	PW_NULO_MONTO_TOTAL			("311013", "valid.integ.nulo.monto.total.pw"),
	PW_NEGATIVO_MONTO_TOTAL		("311014", "valid.integ.negativo.monto.total.pw"),
	PW_NULO_SPERSON				("311015", "valid.integ.nulo.sperson.pw"),
	PW_NEGATIVO_SPERSON			("311016", "valid.integ.negativo.sperson.pw"),
	
	PW_NEGATIVO_NUM_PROCESO		("311017", "valid.integ.negativo.numproceso.pw"),
	
	PW_NULO_RUT_CLIENTE 		("311018", "valid.integ.nulo.rut.cliente.pw"),
	PW_NEGATIVO_RUT_CLIENTE 	("311019", "valid.integ.negativo.rut.cliente.pw"),
	PW_NULO_DV_RUT_CLIENTE		("311020", "valid.integ.nulo.dv.rut.cliente.pw"),
	PW_STR_VACIO_DVRUT_CLIENTE	("311021", "valid.integ.strvacio.dvrut.cliente.pw"),
	PW_NULO_SUCURSAL			("311022", "valid.integ.nulo.sucursal.pw"),
	PW_STR_VACIO_SUCURSAL		("311023", "valid.integ.strvacio.sucursal.pw"),
	PW_NULO_IDEMPRESA			("311024", "valid.integ.nulo.idempresa.pw"),
	PW_NEGATIVO_IDEMPRESA		("311025", "valid.integ.negativo.idempresa.pw"),
	PW_NULO_EMPRESA_PAGO		("311026", "valid.integ.nulo.empresa.pago.pw"),
	PW_STR_VACIO_EMPRESA_PAGO	("311027", "valid.integ.strvacio.empresa.pago.pw"),
	PW_NULO_FORMATO_PAGO		("311028", "valid.integ.nulo.formato.pago.pw"),
	PW_NEGATIVO_FORMATO_PAGO	("311029", "valid.integ.negativo.formato.ppago.pw"),
	
	PW_NEGATIVO_FORMATO_WEB		("311030", "valid.integ.negativo.formato.web.pw"),
	
	PW_NULO_CODIGO_INGRESO		("311031", "valid.integ.nulo.codigo.ingreso.pw"),
	PW_NEGATIVO_CODIGO_INGRESO	("311032", "valid.integ.negativo.codigo.ingreso.pw"),
	PW_NULO_CODIGO_BANCO		("311033", "valid.integ.nulo.codigo.banco.pw"),
	PW_STR_VACIO_CODIGO_BANCO	("311034", "valid.integ.strvacio.codigo.banco.pw"),
	PW_NULO_CUENTA_BANCARIA		("311035", "valid.integ.nulo.cuenta.bancaria.pw"),
	PW_STR_VACIO_CUENTA_BANCARIA("311036", "valid.integ.strvacio.cuenta.bancaria.pw"),
	PW_NULO_ORIGEN				("311037", "valid.integ.nulo.sist.origen.pw"),
	PW_NULO_NOMBRE_USUARIO		("311038", "valid.integ.nulo.nombre.usuario.pw"),
	PW_STR_VACIO_NOMBRE_USUARIO	("311039", "valid.integ.strvacio.nombre.usuario.pw"),
	
	
	//Servicio registro pago web (Detalles)
	PW_DET_NULO_ORIGEN				("311040", "valid.integ.nulo.origen.pwdet"),
	PW_DET_NEGATIVO_ORIGEN			("311041", "valid.integ.negativo.origen.pwdet"),
	PW_DET_NULO_TIPOMOV				("311042", "valid.integ.nulo.tipomov.pwdet"),
	PW_DET_NEGATIVO_TIPOMOV			("311043", "valid.integ.negativo.tipomov.pwdet"),
	PW_DET_NULO_NUM_REFERENCIA		("311044", "valid.integ.nulo.numreferencia.pwdet"),
	PW_DET_NEGATIVO_NUM_REFERENCIA	("311045", "valid.integ.negativo.numreferencia.pwdet"),
	PW_DET_NULO_NUM_CORRELATIVO		("311046", "valid.integ.nulo.numcorrelativo.pwdet"),
	PW_DET_NEGATIVO_NUM_CORRELATIVO	("311047", "valid.integ.negativo.numcorrelativo.pwdet"),
	PW_DET_NULO_NEG_VALOR_CUOTA		("311074", "valid.integ.nulo.neg.valor.cuota.pwdet"),
	PW_DET_NULO_MONTO_EXENTO		("311049", "valid.integ.nulo.monto.exento.pwdet"),
	PW_DET_NEGATIVO_MONTO_EXENTO	("311050", "valid.integ.negativo.monto.exento.pwdet"),
	PW_DET_NULO_MONTO_AFECTO		("311051", "valid.integ.nulo.monto.afecto.pwdet"),
	PW_DET_NEGATIVO_MONTO_AFECTO	("311052", "valid.integ.negativo.monto.afecto.pwdet"),
	PW_DET_NULO_MONTO_IVA			("311053", "valid.integ.nulo.monto.iva.pwdet"),
	PW_DET_NEGATIVO_MONTO_IVA		("311054", "valid.integ.negativo.monto.iva.pwdet"),
	PW_DET_NULO_MONTO_TOTAL			("311055", "valid.integ.nulo.monto.total.pwdet"),
	PW_DET_NEGATIVO_MONTO_TOTAL		("311056", "valid.integ.negativo.monto.total.pwdet"),
	
	PW_DET_NEGATIVO_POLIZA			("311057", "valid.integ.negativo.poliza.pwdet"),
	PW_DET_NEGATIVO_ENDOSO			("311058", "valid.integ.negativo.endoso.pwdet"),
	PW_DET_NEGATIVO_CERTIFICADO		("311059", "valid.integ.negativo.certificado.pwdet"),
	PW_DET_LARGO_MIN_RUT_PROP		("311060", "valid.integ.largo.min.rutprop.pwdet"),
	PW_DET_LARGO_MIN_NOM_PROP		("311061", "valid.integ.largo.min.nomprop.pwdet"),
	
	//Nuevos pago web
	PW_DET_NEGATIVO_CUOTA			("311048", "valid.integ.negativo.cuota.pwdet"),
	PW_NULO_DETALLES				("311078", "valid.integ.nulo.detalles.pwnuevo"),
	
	
	//COMISIONES
	//validaciones de negocio
	COM_BUS_RUT_CORREDOR_FORMATO		("411034", "valid.business.formato.rut.corredor.com"),
	COM_BUS_ANNIO_ACTUAL				("411035", "valid.business.annio.actual.com"),
	COM_BUS_MES_ACTUAL					("411036", "valid.business.mes.actual.com"),
	COM_BUS_RANGO_QUINCENA				("411037", "valid.business.rango.quincena.com"),
	COM_BUS_RANGO_TIPO_OP				("411038", "valid.business.rango.tipo.op.com"),
	COM_BUS_RANGO_DEBEHABER				("411039", "valid.business.rango.debehaber.com"),
	COM_BUS_MONEDA_VALOR_DEFECTO		("411040", "valid.business.valor.default.moneda.com"),
	COM_BUS_SUMA_MONTO_TOTAL			("411041", "valid.business.suma.monto.total.com"),
	COM_BUS_FLOTANTE_MONTO_TOTAL		("411042", "valid.business.flotante.monto.total.com"),
	COM_BUS_FLOTANTE_MONTO_EXENTO		("411043", "valid.business.flotante.monto.exento.com"),
	COM_BUS_FLOTANTE_MONTO_IVA			("411044", "valid.business.flotante.monto.iva.com"),
	COM_BUS_FLOTANTE_MONTO_AFECTO		("411045", "valid.business.flotante.monto.afecto.com"),
	
	//Validaciones de integridad
	COM_NULO_RUT_CORREDOR		("411001", "valid.integ.nulo.rut.corredor.com"),
	COM_LARGO_RUT_CORREDOR		("411002", "valid.integ.largo.rut.corredor.com"),
	COM_NULO_COD_CORREDOR		("411003", "valid.integ.nulo.cod.corredor.com"),
	COM_NULO_ANNIO				("411004", "valid.integ.nulo.annio.com"),
	COM_RANGO_ANNIO				("411005", "valid.integ.rango.annio.com"),
	COM_NULO_MES 				("411006", "valid.integ.nulo.mes.com"),
	COM_RANGO_MES				("411008", "valid.integ.rango.mes.com"),
	COM_NULO_QUINCENA			("411007", "valid.integ.nulo.quincena.com"),
	COM_NULO_DEBEHABER			("411009", "valid.integ.nulo.debehaber.com"),
	COM_NEGATIVO_CONCEPTO_PAGO	("411010", "valid.integ.neg.concepto.pago.com"),
	COM_NULO_CONCEPTO_PAGO		("411011", "valid.integ.nulo.concepto.pago.com"),
	COM_LARGO_MONEDA_PAGO		("411012", "valid.integ.largo.moneda.pago.com"),
	COM_NULO_MONEDA_PAGO		("411013", "valid.integ.nulo.moneda.pago.com"),
	COM_BUS_FORMATO_FECHA_MOV	("411014", "valid.integ.formato.fecha.mov.com"),
	COM_NULO_FECHA_MOV			("411015", "valid.integ.nulo.fecha.mov.com"),
	COM_NULO_TIPO_OP			("411016", "valid.integ.nulo.tipo.op.com"),
	COM_NEGATIVO_MONTO_AFECTO	("411017", "valid.integ.neg.monto.afecto.com"),
	COM_NULO_MONTO_AFECTO		("411018", "valid.integ.nulo.monto.afecto.com"),
	COM_NEGATIVO_MONTO_EXENTO	("411019", "valid.integ.neg.monto.exento.com"),
	COM_NULO_MONTO_EXENTO		("411020", "valid.integ.nulo.monto.exento.com"),
	COM_NEGATIVO_MONTO_IVA		("411021", "valid.integ.neg.monto.iva.com"),
	COM_NULO_MONTO_IVA			("411022", "valid.integ.nulo.monto.iva.com"),
	COM_NEGATIVO_MONTO_TOTAL	("411023", "valid.integ.neg.monto.total.com"),
	COM_NULO_MONTO_TOTAL		("411024", "valid.integ.nulo.monto.total.com"),
	COM_NULO_POLIZA				("411025", "valid.integ.nulo.poliza.com"),
	COM_NULO_CERTIFICADO		("411026", "valid.integ.nulo.certificado.com"),
	COM_NULO_ENDOSO				("411027", "valid.integ.nulo.endoso.com"),
	COM_NULO_ORIGEN				("411028", "valid.integ.nulo.origen.com"),
	COM_NULO_NOMBRE_USUARIO		("411029", "valid.integ.nulo.nombre.usuario.com"),
	COM_LARGO_NOMBRE_USUARIO	("411030", "valid.integ.largo.nombre.usuario.com"),
	COM_LARGO_DESC_MOV			("411031", "valid.integ.largo.desc.mov.com"),
	COM_NULO_DESC_MOV			("411032", "valid.integ.nulo.desc.mov.com"),
	COM_NULO_EMPRESA			("411033", "valid.integ.nulo.empresa.com"),
	
	
	//CONTABILIDAD
	//nuevos
	CONT_LARGO_CODIGO_MONEDA		("511035","valid.integ.largo.codigo.moneda.cont"),
	CONT_LARGO_NOMBRE_COMPLETO		("511036","valid.integ.largo.nombre.completo.cont"),
	CONT_NULO_LISTADO_ASIENTOS		("511037","valid.integ.nulo.listado.asientos.com"),
	CONT_LARGO_NOMBRE_ASIENTO		("511038","valid.integ.largo.nombre.asiento.cont"),
	CONT_LARGO_DESC_LINEA_ASIENTO	("511039","valid.integ.largo.linea.asiento.cont"),
	CONT_LARGO_CODIGO_COMPANIA		("511040","valid.integ.largo.cod.compania.cont"),
	CONT_LARGO_CODIGO_CUENTA		("511041","valid.integ.largo.cod.cuenta.cont"),
	CONT_LARGO_CENTRO_RESPONSAB		("511042","valid.integ.largo.centro.responsab.cont"),
	CONT_LARGO_RAMO					("511043","valid.integ.largo.ramo.cont"),
	CONT_LARGO_LINEA_NEGOCIO		("511044","valid.integ.largo.linea.negocio.cont"),
	CONT_LARGO_CONCEPTO				("511045","valid.integ.largo.concepto.cont"),
	CONT_LARGO_SEGMENTOF1			("511046","valid.integ.largo.segmentof1.cont"),
	CONT_LARGO_SEGMENTOF2			("511047","valid.integ.largo.segmentof2.cont"),
	CONT_LARGO_SEGMENTOF3			("511048","valid.integ.largo.segmentof3.cont"),
	CONT_LARGO_SEGMENTOF4			("511049","valid.integ.largo.segmentof4.cont"),
	
	//negocio
	CONT_BUS_FECHA_CONTABLE			("511005","valid.business.fecha.contable.cont"),
	CONT_BUS_CODIGO_MONEDA			("511025","valid.business.codigo.moneda.cont"),
	CONT_BUS_CPL_DEFAULT_MONTODEBE	("511026","valid.business.cpl.monto.debe.cont"),
	CONT_BUS_MONTO_DEBE_CERO		("511027","valid.business.monto.debe.cero.cont"),
	CONT_BUS_CPL_DEFAULT_MONTOHABER	("511028","valid.business.cpl.monto.haber.cont"),
	CONT_BUS_MONTO_HABER_CERO		("511029","valid.business.monto.haber.cero.cont"),
	CONT_BUS_MONTO_DEBE_HABER_CERO	("511030","valid.business.monto.debe.haber.cero.cont"),
	
	CONT_NULO_ID_EMPRESA		("511001","valid.integ.nulo.idempresa.cont"),
	CONT_MINIMO_ID_EMPRESA		("511002","valid.integ.minimo.idempresa.cont"),
	CONT_NULO_FECHA_CONTABLE	("511003","valid.integ.nulo.fecha.contable.cont"),
	CONT_NULO_NOMBRE_COMPELTO	("511006","valid.integ.nulo.nombre.completo.cont"),
	CONT_NULO_NUMERO_ASIENTO	("511007","valid.integ.nulo.numero.asiento.cont"),
	CONT_MINIMO_NUMERO_ASIENTO	("511008","valid.integ.minimo.numero.asiento.cont"),
	CONT_NULO_NOMBRE_ASIENTO	("511015","valid.integ.nulo.nombre.asiento.cont"),
	CONT_NULO_COD_COMPANIA		("511016","valid.integ.nulo.cod.compania.cont"),
	CONT_NULO_COD_CUENTA		("511017","valid.integ.nulo.cod.cuenta.cont"),
	CONT_NULO_CENTRO_RESPON		("511018","valid.integ.nulo.centro.respon.cont"),
	CONT_NULO_RAMO				("511019","valid.integ.nulo.ramo.cont"),
	CONT_NULO_LINEA_NEGOCIO		("511020","valid.integ.nulo.linea.negocio.cont"),
	CONT_NULO_MONTODEBE			("511021","valid.integ.nulo.montodebe.cont"),
	CONT_MINIMO_MONTODEBE		("511022","valid.integ.minimo.montodebe.cont"),
	CONT_NULO_MONTOHABER		("511023","valid.integ.nulo.montohaber.cont"),
	CONT_MINIMO_MONTOHABER		("511024","valid.integ.minimo.montohaber.cont"),
	
	;
	
	private String codigo;
	private String nombreProperty;
	
	private CodigosValidacionesEnum(String codigo, String nombreProperty){
		this.codigo=codigo;
		this.nombreProperty=nombreProperty;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombreProperty() {
		return nombreProperty;
	}
}
