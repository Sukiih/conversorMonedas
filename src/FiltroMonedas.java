import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;


public class FiltroMonedas {
    public Map<String, Double> filtrarMonedas(String jsonRespuesta){
        //mapa para guardar monedas con sus tasas de camnbio
        Map<String, Double> monedasFiltradas = new HashMap<>();

        //parsear el String JSON a un objeto para manipularlo (PASO 7)
        JsonObject jsonObject = JsonParser.parseString(jsonRespuesta).getAsJsonObject();

        //extraigo el objeto que contiene las monedas y  tasas
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");


        for (String moneda : conversionRates.keySet()){
            double tasa = conversionRates.get(moneda).getAsDouble();
            //Guardar
            monedasFiltradas.put(moneda, tasa);
        }
        return monedasFiltradas;
    }
}
