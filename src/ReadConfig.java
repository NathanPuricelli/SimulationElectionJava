import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
 
/**
 * Cette classe sert à lire le fichier de configuration avec les paramètres de la simulation
 * Le fichier à lire est config.properties.
 * @author Nathan Puricelli, Aymeric Leto
 */
public class ReadConfig {
    
	InputStream inputStream;
	/**
	 * Fonction accédant et retournant les configurations de la simulation
	 * @return Map<String, Float> : Ensemble de données type key:value
	 * @throws IOException
	 */
	public Map<String, String> getPropValues() throws IOException {
        Map<String, String> map = new HashMap<>(); // Assotiation de key / values du fichier de properties.
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			// get the property value and print it out
            map.put("nombreElecteurs", prop.getProperty("nombreElecteurs"));
            map.put("nombreCandidats", prop.getProperty("nombreCandidats"));
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return map;
	}
}