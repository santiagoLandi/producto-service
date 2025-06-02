package com.santiagolandi.productoservice.mapper;

import com.santiagolandi.productoservice.dto.ProductoCreacionDTO;
import com.santiagolandi.productoservice.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoCreacionMapper {
    public ProductoCreacionDTO toCreacionDTO(Producto producto) {
        return new ProductoCreacionDTO(
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getMarca(),
                producto.getCategoria()
        );
    }

    public Producto toProducto(ProductoCreacionDTO productoCreacionDTO) {
        return new Producto(
                productoCreacionDTO.getNombre(),
                productoCreacionDTO.getDescripcion(),
                productoCreacionDTO.getMarca(),
                productoCreacionDTO.getCategoria()
        );
    }
}
