package com.santiagolandi.productoservice.dto;

import jakarta.validation.constraints.NotBlank;

public class ProductoCreacionDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "Debe ingresar una descripcion del producto")
    private String descripcion;
    @NotBlank(message = "Debe ingresar la marca del producto")
    private String marca;
    @NotBlank(message = "La descripcion debe ser valida")
    private String categoria;

    public ProductoCreacionDTO() {}

    public ProductoCreacionDTO(String nombre, String descripcion, String marca, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.categoria = categoria;
    }

    public @NotBlank(message = "El nombre es obligatorio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es obligatorio") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "Debe ingresar una descripcion del producto") String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotBlank(message = "Debe ingresar una descripcion del producto") String descripcion) {
        this.descripcion = descripcion;
    }

    public @NotBlank(message = "Debe ingresar la marca del producto") String getMarca() {
        return marca;
    }

    public void setMarca(@NotBlank(message = "Debe ingresar la marca del producto") String marca) {
        this.marca = marca;
    }

    public @NotBlank(message = "La descripcion debe ser valida") String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotBlank(message = "La descripcion debe ser valida") String categoria) {
        this.categoria = categoria;
    }
}
