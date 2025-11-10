// Editor puede publicar pero no eliminar.
public class Editor extends Usuario {

    public Editor(String id, String nombre) {
        super(id, nombre);
    }

    public boolean puedePublicar() { return true; }
    public boolean puedeEliminar() { return false; }
}
