import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static String obtenerApiKey() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/config.properties"));
            return prop.getProperty("API_KEY");
        } catch (IOException e) {
            throw new RuntimeException("No se pudo leer config.properties", e);
        }
    }
}
