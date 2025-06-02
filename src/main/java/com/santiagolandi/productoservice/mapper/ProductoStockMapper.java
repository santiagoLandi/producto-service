package com.santiagolandi.productoservice.mapper;


import com.santiagolandi.productoservice.dto.ProductoStockDTO;
import com.santiagolandi.productoservice.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoStockMapper {
    public ProductoStockDTO toDTO(Producto producto){
        return new ProductoStockDTO(
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getStock()
        );
    }
}
