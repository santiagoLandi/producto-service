package com.santiagolandi.productoservice.repository;

import com.santiagolandi.productoservice.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    Producto findByNombre(String nombre);

    @Query("SELECT p FROM Producto p WHERE p.nombre=:nombre AND p.marca=:marca")
    Producto findByNombreAndMarca(String nombre, String marca);

    List<Producto> findByMarca(String marca);

    List<Producto> findByCategoria(String categoria);
}
