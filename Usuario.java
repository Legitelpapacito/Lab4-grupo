// Clase base para usuarios del sistema.
public abstract class Usuario {
    protected String id;
    protected String nombre;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Indica si puede publicar.
    public abstract boolean puedePublicar();

    // Indica si puede eliminar.
    public abstract boolean puedeEliminar();
}
