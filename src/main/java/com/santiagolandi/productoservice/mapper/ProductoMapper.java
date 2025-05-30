package com.santiagolandi.productoservice.mapper;

import com.santiagolandi.productoservice.dto.ProductoDTO;
import com.santiagolandi.productoservice.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    public ProductoDTO toProductoDTO(Producto producto) {
        return new ProductoDTO(
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getMarca(),
                producto.getCategoria()
        );
    }
}
