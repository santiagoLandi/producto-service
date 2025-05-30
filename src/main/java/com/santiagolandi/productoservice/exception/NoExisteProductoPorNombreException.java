package com.santiagolandi.productoservice.exception;

public class NoExisteProductoPorNombreException extends RuntimeException {
    public NoExisteProductoPorNombreException(String nombre) {
        super("No existe el producto con el nombre " + nombre);
    }
}
