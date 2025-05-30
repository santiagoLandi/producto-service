package com.santiagolandi.productoservice.exception;

public class NoExisteProductoBuscadoException extends RuntimeException {
    public NoExisteProductoBuscadoException(Long id) {
        super("No se encontro el producto con el id " + id);
    }
}
