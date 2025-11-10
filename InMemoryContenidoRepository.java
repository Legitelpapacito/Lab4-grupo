package cms;

import java.util.*;


public class InMemoryContenidoRepository implements Repository<Contenido> {

    private final Map<String, Contenido> data = new HashMap<>();

    @Override
    public void save(Contenido entity) {
        if (entity == null) throw new IllegalArgumentException("Contenido requerido");
        data.put(entity.getId(), entity);
    }

    @Override
    public Optional<Contenido> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public List<Contenido> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void delete(String id) {
        data.remove(id);
    }
}
