import java.util.ArrayList;
import java.util.List;

// Clase base para cualquier contenido del sistema.
public abstract class Contenido {
    protected String id;
    protected String titulo;
    protected Usuario autor;
    protected Estado estado;
    protected List<Categoria> categorias;

    public Contenido(String id, String titulo, Usuario autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = Estado.BORRADOR;
        this.categorias = new ArrayList<>();
    }

    // Cambia el estado si el usuario tiene permiso.
    public void publicar(Usuario u) {
        if (u.puedePublicar()) {
            this.estado = Estado.PUBLICADO;
            System.out.println("Contenido publicado.");
        } else {
            System.out.println("No tiene permisos para publicar.");
        }
    }

    // Cada tipo define cómo se muestra.
    public abstract String renderizar();
}
