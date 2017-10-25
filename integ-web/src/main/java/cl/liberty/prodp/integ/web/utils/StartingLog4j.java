package cl.liberty.prodp.integ.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class StartingLog4j extends HttpServlet{

	private static final long serialVersionUID = -3278729674357132836L;
	private static final Logger LOGGER = Logger.getLogger(StartingLog4j.class);
	private static final String LOG4J_NAME_FILE = "integ-web-log4j.properties";
	private static final String PATH_USER_WAS = "user.install.root";
	private static final String PATH_PROP = "properties";
		
    public StartingLog4j()     {
        super();
    }
 
    @Override
    public  void init()     {
        Properties configProps = new Properties();
        try {
        	
            configProps.clear();
            String path = System.getProperty(PATH_USER_WAS);

            String ultimoCaracter = path.substring(path.length()-1);
        	if (!ultimoCaracter.equals(File.separator)){ 
        		path = path.concat(File.separator);
            }
            
            path = path.concat(PATH_PROP).concat(File.separator);
            
            String file = path.concat(LOG4J_NAME_FILE);
            FileInputStream fis = new FileInputStream(new File(file));
            
            configProps.load(fis);
            PropertyConfigurator.configure(configProps);
            
        } catch (Exception e) {
        	LOGGER.error(StartingLog4j.class.getSimpleName() + " : " + e, e);
        }
    }
 
    public static Logger getLogger() {
        return LOGGER;
    }
	
}
