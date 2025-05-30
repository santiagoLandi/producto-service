package com.santiagolandi.productoservice.exception;

public class SinProductosPorCategoriaException extends RuntimeException {
    public SinProductosPorCategoriaException(String categoria) {
        super("No existen productos con la categoria: "+categoria);
    }
}
