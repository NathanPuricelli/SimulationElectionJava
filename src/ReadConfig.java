/**
 * @author Nathan Puricelli et Aymeric Leto
 * Fichier de la classe ReadConfig
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
 
/**
 * @class Cette classe sert à lire le fichier de configuration avec les paramètres de la simulation
 */
public class ReadConfig {
    
	InputStream inputStream;
	/**
	 * Fonction accédant et retournant les configurations de la simulation
	 * @return Map<String, Float> : Ensemble de données type key:value
	 * @throws IOException
	 */
	public Map<String, Float> getPropValues() throws IOException {
        Map<String, Float> map = new HashMap<>();
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
			int nombreElecteurs = Integer.parseInt(prop.getProperty("nombreElecteurs"));
            map.put("nombreElecteurs", (float)nombreElecteurs);
			int nombreCandidats = Integer.parseInt(prop.getProperty("nombreCandidats"));
            map.put("nombreCandidats", (float)nombreCandidats);
 
			
			System.out.println(map);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return map;
	}
}