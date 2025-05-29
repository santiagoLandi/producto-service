package com.santiagolandi.productoservice.repository;

import com.santiagolandi.productoservice.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


    
}
