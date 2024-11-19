import java.util.Scanner;

public class Programa02 {
    static GestorProductos gestorProductos = new GestorProductos();
    static GestorClientes gestorClientes = new GestorClientes();
    static GestorVentas gestorVentas = new GestorVentas();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú del Sistema ---");
            System.out.println("1. Ingresar Producto");
            System.out.println("2. Mostrar Productos");
            System.out.println("3. Ingresar Cliente");
            System.out.println("4. Mostrar Clientes");
            System.out.println("5. Realizar Venta");
            System.out.println("6. Mostrar Ventas Realizadas");
            System.out.println("7. Modificar Producto");
            System.out.println("8. Reporte de Inventario por Categorías");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar el buffer

            switch (opcion) {
                case 1 -> gestorProductos.ingresarProducto();
                case 2 -> gestorProductos.mostrarProductos();
                case 3 -> gestorClientes.ingresarCliente();
                case 4 -> gestorClientes.mostrarClientes();
                case 5 -> gestorVentas.realizarVenta(gestorProductos, gestorClientes);
                case 6 -> gestorVentas.mostrarVentas();
                case 7 -> gestorProductos.modificarProducto();
                case 8 -> gestorProductos.reporteInventario();
                case 9 -> {
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }
}
