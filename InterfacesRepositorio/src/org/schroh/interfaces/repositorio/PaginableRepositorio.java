package org.schroh.interfaces.repositorio;

import java.util.List;

public interface PaginableRepositorio<T> { // Esta interfaz es por si tenemos por ejemplo 1000 clientes, y paginamos de 10 en 10 envez de traer todos...
    List<T> listar(int desde, int hasta);
}
