import java.util.ArrayList;
import java.util.Scanner;

public class GestorProductos {
    private ArrayList<Producto> productos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void ingresarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        double precio;
        do {
            System.out.print("Ingrese el precio del producto (debe ser mayor a 0): ");
            precio = scanner.nextDouble();
            if (precio <= 0) {
                System.out.println("El precio debe ser mayor a 0.");
            }
        } while (precio <= 0);

        int stock;
        do {
            System.out.print("Ingrese el stock del producto (debe ser mayor o igual a 0): ");
            stock = scanner.nextInt();
            if (stock < 0) {
                System.out.println("El stock no puede ser negativo.");
            }
        } while (stock < 0);

        scanner.nextLine(); // limpiar el buffer
        System.out.print("Ingrese la categoría del producto: ");
        String categoria = scanner.nextLine();

        productos.add(new Producto(nombre, precio, stock, categoria));
        System.out.println("Producto agregado exitosamente.");
    }

    public void mostrarProductos() {
        System.out.println("\n--- Lista de Productos ---");
        for (Producto producto : productos) {
            producto.mostrarProducto();
        }
    }

    public void modificarProducto() {
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombre = scanner.nextLine();

        Producto producto = buscarProducto(nombre);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Ingrese el nuevo precio: ");
        producto.setPrecio(scanner.nextDouble());
        System.out.print("Ingrese el nuevo stock: ");
        producto.setStock(scanner.nextInt());
        scanner.nextLine(); // limpiar buffer
        System.out.print("Ingrese la nueva categoría: ");
        producto.setCategoria(scanner.nextLine());

        System.out.println("Producto modificado exitosamente.");
    }

    public void reporteInventario() {
        System.out.println("\n--- Reporte de Inventario por Categorías ---");
        String[] categorias = {"Bebidas", "Snacks", "Lácteos"};
        int[] totalStock = new int[categorias.length];
        double[] totalValor = new double[categorias.length];

        for (Producto p : productos) {
            for (int i = 0; i < categorias.length; i++) {
                if (p.getCategoria().equalsIgnoreCase(categorias[i])) {
                    totalStock[i] += p.getStock();
                    totalValor[i] += p.getPrecio() * p.getStock();
                }
            }
        }

        System.out.println("Categoría\tStock\tValor Total");
        for (int i = 0; i < categorias.length; i++) {
            System.out.println(categorias[i] + "\t\t" + totalStock[i] + "\t" + totalValor[i]);
        }
    }

    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
}
