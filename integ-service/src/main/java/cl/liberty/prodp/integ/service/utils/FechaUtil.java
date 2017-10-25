package cl.liberty.prodp.integ.service.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FechaUtil {
	
	private FechaUtil() {
		
	}

	public static java.util.Date convertStringtoUtilDate(String fecha) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		java.util.Date parsed = format.parse(fecha);

		return parsed;
	}
	
	public static Date convertStringtoSqlDate(String fecha) throws ParseException{
		
		Date sqlDate;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		
		java.util.Date parsed = format.parse(fecha);
		sqlDate = new java.sql.Date(parsed.getTime());

		return sqlDate;
	}
	
	public static Timestamp convertStringtoSqlTimestamp(String fecha) throws ParseException{
		
		Timestamp sqlDate;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

		java.util.Date parsed = format.parse(fecha);
		sqlDate = new java.sql.Timestamp(parsed.getTime());
		
		return sqlDate;
	}
	
	public static String convertSqlDateToString(Date fecha){
		
		String text;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		
		text = format.format(fecha); 

		return text;
	}
	
	public static String convertSqlTimestampToString(Timestamp fecha){
		
		String text;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		
		text = format.format(fecha); 

		return text;
	}
	
}
