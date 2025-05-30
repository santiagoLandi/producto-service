package com.santiagolandi.productoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationException(MethodArgumentNotValidException ex) {
        String detalle = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                .orElse("Datos inválidos");
        ErrorMessage error = new ErrorMessage("Validación fallida", detalle);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // 👇 Manejo de excepcion ante falta de productos para mostar
    @ExceptionHandler(SinProductosException.class)
    public ResponseEntity<ErrorMessage> handleSinProductos(SinProductosException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("No existen productos para mostrar", ex.getMessage()));
    }
    // Cuando no existe el producto buscado
    @ExceptionHandler(NoExisteProductoBuscadoException.class)
    public ResponseEntity<ErrorMessage> handleNoSeEncuentraProductoConId(NoExisteProductoBuscadoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("No existe producto con el id buscado", ex.getMessage()));
    }

    //Cuando quiero ingresar un producto que ya ha sido cargado
    @ExceptionHandler(ProductoYaExisteException.class)
    public ResponseEntity<ErrorMessage> handleProductoYaIngresado(ProductoYaExisteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage("No se puede ingresar el producto", ex.getMessage()));
    }

    //Cuando quiero buscar un producto por nombre y no existe
    @ExceptionHandler(NoExisteProductoPorNombreException.class)
    public ResponseEntity<ErrorMessage> handleProductoNoExistePorNombre(NoExisteProductoPorNombreException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage("No existe el producto", ex.getMessage()));
    }
    // Cuando no existen productos buscados por la categoria ingresada
    @ExceptionHandler(SinProductosPorCategoriaException.class)
    public ResponseEntity<ErrorMessage> handleProductoNoExistePorCategoria(SinProductosPorCategoriaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage("No existe el producto", ex.getMessage()));
    }

    // Cuando no existen productos buscados por la marca ingresada
    @ExceptionHandler(SinProductosPorMarcaException.class)
    public ResponseEntity<ErrorMessage> handleProductoNoExistePorMarca(SinProductosPorMarcaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage("No existe el producto", ex.getMessage()));
    }
}
record ErrorMessage(String mensaje, String detalle) {}
