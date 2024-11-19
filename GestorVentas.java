import java.util.ArrayList;

public class GestorVentas {
    private ArrayList<Venta> ventas = new ArrayList<>();

    public void realizarVenta(GestorProductos gestorProductos, GestorClientes gestorClientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        Cliente cliente = gestorClientes.buscarCliente(nombreCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        Producto producto = gestorProductos.buscarProducto(nombreProducto);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Ingrese la cantidad a comprar: ");
        int cantidad = scanner.nextInt();

        if (cantidad > producto.getStock()) {
            System.out.println("No hay suficiente stock.");
        } else {
            producto.setStock(producto.getStock() - cantidad);
            ventas.add(new Venta(cliente, producto, cantidad));
            System.out.println("Venta realizada exitosamente.");
        }
    }

    public void mostrarVentas() {
        System.out.println("\n--- Ventas Realizadas ---");
        for (Venta venta : ventas) {
            venta.mostrarVenta();
        }
    }
}

