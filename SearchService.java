package cms;

import java.util.ArrayList;
import java.util.List;


public class SearchService implements Buscable {

    private final Repository<Contenido> repo;

    public SearchService(Repository<Contenido> repo) {
        if (repo == null) throw new IllegalArgumentException("Repositorio requerido");
        this.repo = repo;
    }

    @Override
    public List<Contenido> buscarPorTipo(Class<? extends Contenido> tipo) {
        List<Contenido> result = new ArrayList<>();
        for (Contenido c : repo.findAll()) {
            if (tipo.isInstance(c)) result.add(c);
        }
        return result;
    }

    @Override
    public List<Contenido> filtrarPorCategoria(String nombreCategoria) {
        List<Contenido> result = new ArrayList<>();
        if (nombreCategoria == null || nombreCategoria.isBlank()) return result;

        for (Contenido c : repo.findAll()) {
            boolean coincide = c.getCategorias().stream()
                    .anyMatch(cat -> cat.getNombre().equalsIgnoreCase(nombreCategoria));
            if (coincide) result.add(c);
        }
        return result;
    }
}

