package ca.inventarios.controller;

import ca.inventarios.model.Producto;
import ca.inventarios.service.IProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario-app") //http://localhost:8080/api/inventario-app
@CrossOrigin(origins = "http://localhost:4200") //Permite conexión desde cualquier origen
public class ProductoControlador {

    private final IProductoServicio productoServicio;

    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    public ProductoControlador(IProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    // GET /api/inventario-app
    @GetMapping
    public List<Producto> listarProductos() {
        List<Producto> productos = productoServicio.listarProducto();
        logger.info("Productos obtenidos: ");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

    //BUSCAR PRODUCTO POR ID
    @GetMapping("/{id}")
    public Producto buscarProductoPorId(@PathVariable Integer id) {
        return productoServicio.buscarProductoPorId(id);
    }

    //CREAR PRODUCTO
    @PostMapping
    public Producto gardarProducto(@RequestBody Producto producto) {
        return productoServicio.guardarProducto(producto);
    }

    //ACTUALIZAR PRODUCTO
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        producto
                .setIdProducto(id);
        return productoServicio.guardarProducto(producto);
    }

    //ELIMINAR PRODUCTO
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        productoServicio.eliminarProductoPorId(id);
    }

}
