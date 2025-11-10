package cms;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public class ContentController {

    private final Repository<Contenido> repo;
    private final Buscable buscador;
    private final Reportable reportador;

    public ContentController(Repository<Contenido> repo, Buscable buscador, Reportable reportador) {
        this.repo = repo;
        this.buscador = buscador;
        this.reportador = reportador;
    }

    public void crear(Contenido c) {
        repo.save(c);
    }

    public void editar(String id, Map<String, Object> cambios) {
        Optional<Contenido> opt = repo.findById(id);
        if (opt.isEmpty()) throw new IllegalArgumentException("No existe contenido con ID " + id);
        Contenido c = opt.get();

        if (cambios.containsKey("titulo"))
            c.setTitulo((String) cambios.get("titulo"));

        if (c instanceof Articulo && cambios.containsKey("cuerpoMarkdown"))
            ((Articulo) c).setCuerpoMarkdown((String) cambios.get("cuerpoMarkdown"));

        if (c instanceof Video) {
            if (cambios.containsKey("url"))
                ((Video) c).setUrl((String) cambios.get("url"));
            if (cambios.containsKey("descripcion"))
                ((Video) c).setDescripcion((String) cambios.get("descripcion"));
        }

        if (c instanceof Imagen) {
            if (cambios.containsKey("rutaArchivo"))
                ((Imagen) c).setRutaArchivo((String) cambios.get("rutaArchivo"));
            if (cambios.containsKey("textoAlternativo"))
                ((Imagen) c).setTextoAlternativo((String) cambios.get("textoAlternativo"));
        }

        repo.save(c);
    }

    public void eliminar(String id, Usuario u) {
        if (u == null || !u.puedeEliminar())
            throw new SecurityException("El usuario no tiene permiso para eliminar");
        repo.delete(id);
    }

    public void publicar(String id, Usuario u) {
        Contenido c = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe contenido con ID " + id));
        c.publicar(u);
        repo.save(c);
    }

    
    public List<Contenido> buscarPorTipo(Class<? extends Contenido> tipo) {
        return buscador.buscarPorTipo(tipo);
    }

    public List<Contenido> filtrarPorCategoria(String categoria) {
        return buscador.filtrarPorCategoria(categoria);
    }

    public Map<String, Integer> resumenPorTipo() {
        return reportador.resumenPorTipo();
    }
}
