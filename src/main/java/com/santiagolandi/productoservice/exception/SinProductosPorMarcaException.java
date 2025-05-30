package com.santiagolandi.productoservice.exception;

public class SinProductosPorMarcaException extends RuntimeException {
    public SinProductosPorMarcaException(String marca) {
        super("No existen productos de la marca: " + marca);
    }
}
