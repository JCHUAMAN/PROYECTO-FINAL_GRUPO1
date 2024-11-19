public class Cliente {
    private String nombre;
    private String cedula;

    public Cliente(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarCliente() {
        System.out.println("Nombre: " + nombre + ", Cédula: " + cedula);
    }
}
