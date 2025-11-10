package cms;

import java.util.HashMap;
import java.util.Map;


public class ReportService implements Reportable {

    private final Repository<Contenido> repo;

    public ReportService(Repository<Contenido> repo) {
        if (repo == null) throw new IllegalArgumentException("Repositorio requerido");
        this.repo = repo;
    }

    @Override
    public Map<String, Integer> resumenPorTipo() {
        Map<String, Integer> conteo = new HashMap<>();
        for (Contenido c : repo.findAll()) {
            String tipo = c.getClass().getSimpleName();
            conteo.put(tipo, conteo.getOrDefault(tipo, 0) + 1);
        }
        return conteo;
    }
}
