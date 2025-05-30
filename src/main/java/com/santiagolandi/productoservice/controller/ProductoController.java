package com.santiagolandi.productoservice.controller;

import com.santiagolandi.productoservice.dto.ProductoDTO;
import com.santiagolandi.productoservice.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("registrar")
    public ResponseEntity<?>registrarProducto(@RequestBody ProductoDTO productoDTO) {
        productoService.registrarProducto(productoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoDTO);
    }

    @GetMapping("/")
    public ResponseEntity<?>listarProductos() {
        List<ProductoDTO> listaProductos = productoService.listarProductos();
        return ResponseEntity.ok(listaProductos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>listarProductoPorId(@PathVariable Long id) {
        ProductoDTO producto = productoService.buscarProductoPorId(id);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        productoService.actualizarProducto(productoDTO, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        productoService.borrarProducto(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Producto borrado correctamente");
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?>listarProductosPorNombre(@PathVariable String nombre) {
        ProductoDTO producto = productoService.buscarProductoPorNombre(nombre);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<?>listarProductosPorMarca(@PathVariable String marca) {
        List<ProductoDTO>productos = productoService.buscarProductoPorMarca(marca);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<?>listarProductosPorCategoria(@PathVariable String categoria) {
        List<ProductoDTO>productos = productoService.buscarProductoPorCategoria(categoria);
        return ResponseEntity.ok(productos);
    }
}
