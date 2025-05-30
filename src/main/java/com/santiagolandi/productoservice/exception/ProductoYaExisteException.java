package com.santiagolandi.productoservice.exception;

public class ProductoYaExisteException extends RuntimeException {
    public ProductoYaExisteException(String nombre,String marca) {
        super("El producto ya existe con nombre: " + nombre + "de la marca: "+ marca + "ya existe");
    }
}
