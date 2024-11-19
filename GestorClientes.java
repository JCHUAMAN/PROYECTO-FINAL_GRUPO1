import java.util.ArrayList;
import java.util.Scanner;

public class GestorClientes {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void ingresarCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cédula del cliente: ");
        String cedula = scanner.nextLine();

        clientes.add(new Cliente(nombre, cedula));
        System.out.println("Cliente agregado exitosamente.");
    }

    public void mostrarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        for (Cliente cliente : clientes) {
            cliente.mostrarCliente();
        }
    }

    public Cliente buscarCliente(String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }
}
