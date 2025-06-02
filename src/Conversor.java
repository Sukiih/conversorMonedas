import java.util.Map;
import java.util.Scanner;

public class Conversor {

    private final Cliente cliente;
    private final FiltroMonedas filtro;
    private final ConversorMonedas conversor;

    public Conversor() {
        this.cliente = new Cliente();
        this.filtro = new FiltroMonedas();
        this.conversor = new ConversorMonedas();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        String monedaBase;
        String monedaDestino;
        double cantidad;

        while (true) {
            System.out.println("\n👋 Bienvenido/a al Conversor de Moneda");
            System.out.println("Seleccione la opción:");
            System.out.println("1. Convertir monedas");
            System.out.println("2. Ver todas las tasas desde una moneda base");
            System.out.println("3. Salir");

            System.out.print("Opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    try {
                        System.out.print("Ingrese la moneda base (ej: USD): ");
                        monedaBase = scanner.nextLine().toUpperCase();

                        System.out.print("Ingrese la moneda destino (ej: EUR): ");
                        monedaDestino = scanner.nextLine().toUpperCase();

                        System.out.print("Ingrese la cantidad a convertir: ");
                        cantidad = Double.parseDouble(scanner.nextLine());

                        String respuesta = cliente.obtenerTasaCambio(monedaBase);
                        Map<String, Double> tasas = filtro.filtrarMonedas(respuesta);

                        if (!tasas.containsKey(monedaDestino)) {
                            System.out.println("❌ Moneda destino no válida.");
                            break;
                        }

                        double tasa = tasas.get(monedaDestino);
                        double resultado = conversor.convertir(cantidad, tasa);

                        System.out.printf("Resultado: %.2f %s = %.2f %s%n", cantidad, monedaBase.toUpperCase(), resultado, monedaDestino.toUpperCase());
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case "2":
                    try {
                        System.out.print("Ingrese la moneda base (ej: USD): ");
                        monedaBase = scanner.nextLine().toUpperCase();

                        String respuesta = cliente.obtenerTasaCambio(monedaBase);
                        Map<String, Double> tasas = filtro.filtrarMonedas(respuesta);

                        System.out.println("Tasas de cambio para " + monedaBase + ":");
                        tasas.forEach((moneda, tasa) -> System.out.println(moneda + " : " + tasa));
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;

                case "3":
                    System.out.println("👋 ¡Hasta luego!");
                    return;

                default:
                    System.out.println("⚠️ Elija una opción válida. ⚠️");
            }
        }
    }
}
