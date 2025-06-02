import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class Cliente {

    private static final String API_KEY = Config.obtenerApiKey();
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient httpClient;

    //paso 4
    public Cliente() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public double obtenerTasaCambio(String monedaBase, String monedaObjetivo) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/pair/" + monedaBase + "/" + monedaObjetivo;

        //Paso 5
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        //Paso 6
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        //paso 7 Json
        Gson gson = new Gson();
        RespuestaTasaCambio datos = gson.fromJson(response.body(), RespuestaTasaCambio.class);

        return datos.getConversion_rate();
    }
}
