package cms;

import java.util.List;


public interface Buscable {
    List<Contenido> buscarPorTipo(Class<? extends Contenido> tipo);
    List<Contenido> filtrarPorCategoria(String nombreCategoria);
}
