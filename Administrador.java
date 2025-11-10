// Administrador con permisos completos.
public class Administrador extends Usuario {

    public Administrador(String id, String nombre) {
        super(id, nombre);
    }

    public boolean puedePublicar() { return true; }
    public boolean puedeEliminar() { return true; }
}
