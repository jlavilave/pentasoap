package cl.liberty.prodp.integ.service.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.naming.NamingException;

import org.springframework.stereotype.Component;

@Component("msgValid")
public class Propiedades {
	
	private static final String MSG_VALIDACIONES_PROPERTIES = "integ-web-msgValidaciones.properties";
	private static final String CONFIGS_PROPERTIES = "integ-web-configs.properties";
	private static final String PATH_USER_WAS = "user.install.root";
	private static final String PATH_PROP = "properties";
	
	public String getProperty(String propiedad, Object... params) throws IOException{
		
		try {
			Properties prop = new Properties();
			InputStream input = null;
			input = new FileInputStream(new File(this.getDirProps().concat(MSG_VALIDACIONES_PROPERTIES)));
			
			prop. load(input);
			String message = prop.getProperty(propiedad);
			
			if(params.length > 0){
				message = MessageFormat.format( message, params);
			}
			return message;
		} catch (IOException e) {
			throw new IOException(e);
		} catch (Exception e) {
			throw new IOException(e);
		}
	}	
	
	public String getProperty(String propiedad) throws IOException{
		
		try {
			Properties prop = new Properties();
			InputStream input = null;
			input = new FileInputStream(new File(this.getDirProps().concat(MSG_VALIDACIONES_PROPERTIES)));
			
			prop. load(input);
			String message = prop.getProperty(propiedad);

			return message;
		} catch (IOException e) {
			throw new IOException(e);
		} catch (Exception e) {
			throw new IOException(e);
		}
	}
	
	public String getPropertyConf(String propiedad) throws IOException{
		
		try {
			Properties prop = new Properties();
			InputStream input = null;
			input = new FileInputStream(new File(this.getDirProps().concat(CONFIGS_PROPERTIES)));
			
			prop. load(input);
			String message = prop.getProperty(propiedad);
			
			return message;
		} catch (IOException e) {
			throw new IOException(e);
		} catch (Exception e) {
			throw new IOException(e);
		}
	}	
	
	
    private String getDirProps() throws NamingException{
    	
    	
    	String path = System.getProperty(PATH_USER_WAS);
    	
    	String ultimoCaracter = path.substring(path.length()-1);
    	if (!ultimoCaracter.equals(File.separator)){ 
    		path = path.concat(File.separator);
        }
    	
    	path = path.concat(PATH_PROP).concat(File.separator);
    	
    	return path;
    }
}
