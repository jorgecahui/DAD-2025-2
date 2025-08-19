package com.example.ms_producto.Controller;

import com.example.ms_producto.Entity.Producto;
import com.example.ms_producto.Service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listar() {
        return productoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Producto> buscarPorId(@PathVariable Integer id) {
        return productoService.buscarPorId(id);
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    @PutMapping
    public Producto actualizar(@RequestBody Producto producto) {
        return productoService.actualizar(producto);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return "Producto eliminado";
    }
}
