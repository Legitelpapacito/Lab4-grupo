// Representa un artículo escrito.
public class Articulo extends Contenido {
    private String texto;

    public Articulo(String id, String titulo, Usuario autor, String texto) {
        super(id, titulo, autor);
        this.texto = texto;
    }

    public String renderizar() {
        return "Artículo: " + titulo + "\n" + texto;
    }
}
