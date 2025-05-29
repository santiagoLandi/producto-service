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
    @NotNull(message = "El precio unitario es obligatorio")
    private Double precioUnitario;
    @NotNull(message = "El stock es obligatorio de ingresar")
    private Long stock;

    public ProductoDTO() {}

    public ProductoDTO(String nombre, String descripcion, String marca, String categoria, Double precioUnitario, Long stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
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

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
