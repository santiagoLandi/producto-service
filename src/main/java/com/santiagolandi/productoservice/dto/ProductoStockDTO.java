package com.santiagolandi.productoservice.dto;

import jakarta.validation.constraints.NotBlank;

public class ProductoStockDTO {

    private String nombre;

    private String descripcion;

    private Integer stock;

    public ProductoStockDTO(String nombre, String descripcion, Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
