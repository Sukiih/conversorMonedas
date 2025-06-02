import java.io.IOException;
import java.util.Map;

public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        FiltroMonedas filtro = new FiltroMonedas();

        try {
            // Paso 7: obtenemos el JSON crudo
            String jsonRespuesta = cliente.obtenerTasaCambio("USD");

            // Paso 8: filtramos las monedas y tasas de cambio
            Map<String, Double> tasas = filtro.filtrarMonedas(jsonRespuesta);

            // Ejemplo: mostramos la tasa USD -> EUR
            System.out.println("Tasa de cambio USD -> EUR: " + tasas.get("EUR"));

            // Mostrar todas las monedas y tasas
            System.out.println("Todas las tasas:");
            tasas.forEach((moneda, tasa) -> System.out.println(moneda + " : " + tasa));

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener tasas de cambio: " + e.getMessage());
        }
    }
}
