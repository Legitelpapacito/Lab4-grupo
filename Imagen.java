// Representa una imagen.
public class Imagen extends Contenido {
    private String ruta;

    public Imagen(String id, String titulo, Usuario autor, String ruta) {
        super(id, titulo, autor);
        this.ruta = ruta;
    }

    public String renderizar() {
        return "Imagen: " + titulo + "\n" + ruta;
    }
}
