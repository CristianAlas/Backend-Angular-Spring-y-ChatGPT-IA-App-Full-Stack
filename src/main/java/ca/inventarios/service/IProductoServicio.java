package ca.inventarios.service;

import ca.inventarios.model.Producto;

import java.util.List;

public interface IProductoServicio {
    List<Producto> listarProducto();
    Producto buscarProductoPorId(Integer idProducto);
    Producto guardarProducto(Producto producto);
    void eliminarProductoPorId(Integer idProducto);
}
