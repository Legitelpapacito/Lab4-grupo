// Representa un video.
public class Video extends Contenido {
    private String url;

    public Video(String id, String titulo, Usuario autor, String url) {
        super(id, titulo, autor);
        this.url = url;
    }

    public String renderizar() {
        return "Video: " + titulo + "\n" + url;
    }
}
