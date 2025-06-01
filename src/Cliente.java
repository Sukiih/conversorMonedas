import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Cliente {

    private static final String API_KEY = "547b7f3ac97d42561c4b800b";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient httpClient;

    public Cliente() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String obtenerTasaCambio(String monedaBase, String monedaObjetivo) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/pair/" + monedaBase + "/" + monedaObjetivo;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
