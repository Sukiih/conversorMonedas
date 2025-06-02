import java.io.IOException;
import java.util.Map;

public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        FiltroMonedas filtro = new FiltroMonedas();
        ConversorMonedas conversor = new ConversorMonedas();
        Conversor menu = new Conversor();
        menu.mostrarMenu();

        try {
            // Paso 7
            String jsonRespuesta = cliente.obtenerTasaCambio("USD");

            // Paso 8
            Map<String, Double> tasas = filtro.filtrarMonedas(jsonRespuesta);

            //paso 9
            double tasa = tasas.get("EUR");
            double convertido = conversor.convertir(100, tasa);
            /*test
            System.out.println("100 USD equivalen a " + convertido + " EUR");
            */
            /* Mostrar todas las monedas y tasas
            System.out.println("Todas las tasas:");
            tasas.forEach((moneda, tasaMoneda) -> System.out.println(moneda + " : " + tasaMoneda));
            */
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener tasas de cambio: " + e.getMessage());
        }
    }
}
