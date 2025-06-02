import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        try {
            double tasa  = cliente.obtenerTasaCambio("USD", "EUR");
            System.out.println("Tasa de cambio USD -> EUR: " + tasa);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener tasas de cambio: " + e.getMessage());
        }
    }
}
