import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try {
            String respuestaJson = cliente.obtenerTasaCambio("USD", "EUR");
            System.out.println(respuestaJson);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener tasas de cambio: " + e.getMessage());
        }
    }
}
