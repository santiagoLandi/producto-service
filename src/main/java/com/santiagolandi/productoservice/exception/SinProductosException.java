package com.santiagolandi.productoservice.exception;

public class SinProductosException extends RuntimeException {
    public SinProductosException() {
        super("No existen productos para mostrar");
    }
}
