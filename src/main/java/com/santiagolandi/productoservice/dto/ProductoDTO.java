package com.santiagolandi.productoservice.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductoDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "Debe ingresar una descripcion del producto")
    private String descripcion;
    @NotBlank(message = "Debe ingresar la marca del producto")
    private String marca;
    @NotBlank(message = "La descripcion debe ser valida")
    private String categoria;
    @NotNull(message = "El stock no puede ser negativo")
    private Integer stock;

    public ProductoDTO() {}

    public ProductoDTO(String nombre, String descripcion, String marca, String categoria, Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.categoria = categoria;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
