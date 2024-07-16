package org.schroh.supermercado.interfaces;

import java.util.List;

public interface IProducto<T> {
    void addProducto(T producto);
    List<T> getProductos();
}
