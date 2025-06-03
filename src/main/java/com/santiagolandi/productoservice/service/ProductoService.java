package com.santiagolandi.productoservice.service;

import com.santiagolandi.productoservice.dto.ProductoCreacionDTO;
import com.santiagolandi.productoservice.dto.ProductoDTO;
import com.santiagolandi.productoservice.dto.ProductoStockDTO;
import com.santiagolandi.productoservice.dto.SumarStockRequest;
import com.santiagolandi.productoservice.entity.Producto;
import com.santiagolandi.productoservice.exception.*;
import com.santiagolandi.productoservice.mapper.ProductoCreacionMapper;
import com.santiagolandi.productoservice.mapper.ProductoMapper;
import com.santiagolandi.productoservice.mapper.ProductoStockMapper;
import com.santiagolandi.productoservice.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;
    private final ProductoStockMapper productoStockMapper;
    private final ProductoCreacionMapper productoCreacionMapper;

    @Autowired
    public ProductoService(ProductoRepository productoRepository, ProductoMapper productoMapper, ProductoStockMapper productoStockMapper, ProductoCreacionMapper productoCreacionMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
        this.productoStockMapper = productoStockMapper;
        this.productoCreacionMapper = productoCreacionMapper;
    }

    @Transactional
    public ProductoCreacionDTO registrarProducto(ProductoCreacionDTO productoDTO) {
        Producto existente = productoRepository.findByNombreAndMarca(productoDTO.getNombre(),productoDTO.getMarca());
        if (existente != null) {
            throw new ProductoYaExisteException(productoDTO.getNombre(),productoDTO.getMarca());
        }
        Producto producto = productoCreacionMapper.toProducto(productoDTO);
        productoRepository.save(producto);
        return productoCreacionMapper.toCreacionDTO(producto);
    }

    private ProductoDTO mapearAdto(ProductoDTO productoDTO, Producto producto) {
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setMarca(productoDTO.getMarca());
        producto.setCategoria(productoDTO.getCategoria());
        return productoMapper.toProductoDTO(producto) ;
    }

    @Transactional(readOnly = true)
    public List<ProductoDTO> listarProductos() {
        List<Producto> productos = productoRepository.findAll();
        if (productos.isEmpty()) {
            throw new SinProductosException();
        }
        return productos.stream().map(productoMapper::toProductoDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductoDTO buscarProductoPorId(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new NoExisteProductoBuscadoException(id));
        return productoMapper.toProductoDTO(producto);
    }

    @Transactional
    public String borrarProducto(Long id) {
        Producto buscado = productoRepository.findById(id).orElseThrow(() -> new NoExisteProductoBuscadoException(id));
        productoRepository.delete(buscado);
        return "El producto " + buscado.getNombre() + " ha sido borrado.";
    }

    @Transactional
    public ProductoDTO actualizarProducto(ProductoDTO productoDTO, Long id) {
        Producto buscado = productoRepository.findById(id).orElseThrow(() -> new NoExisteProductoBuscadoException(id));
        mapearAdto(productoDTO, buscado);
        productoRepository.save(buscado);
        return productoMapper.toProductoDTO(buscado);
    }

    @Transactional(readOnly = true)
    public ProductoDTO buscarProductoPorNombre(String nombre) {
        Producto producto = productoRepository.findByNombre(nombre);
        if (producto == null) {
            throw new NoExisteProductoPorNombreException(nombre);
        }
        return productoMapper.toProductoDTO(producto);
    }

    @Transactional(readOnly = true)
    public List<ProductoDTO> buscarProductoPorCategoria(String categoria) {
        List<Producto> productos = productoRepository.findByCategoria(categoria);
        if (productos.isEmpty()) {
            throw new SinProductosPorCategoriaException(categoria);
        }
        return productos.stream().map(productoMapper::toProductoDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductoDTO> buscarProductoPorMarca(String marca) {
        List<Producto> productos = productoRepository.findByMarca(marca);
        if (productos.isEmpty()) {
            throw new SinProductosPorMarcaException(marca);
        }
        return productos.stream().map(productoMapper::toProductoDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductoStockDTO mostrarStock(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new NoExisteProductoBuscadoException(id));
        return productoStockMapper.toDTO(producto);
    }

    @Transactional
    public ProductoDTO sumarStock(Long id, SumarStockRequest cantidad){
        Producto producto = productoRepository.findById(id).orElseThrow(()-> new NoExisteProductoBuscadoException(id));
        Integer cantidadComprada = cantidad.getStock();
        producto.setStock(producto.getStock() + cantidadComprada);
        productoRepository.save(producto);
        return productoMapper.toProductoDTO(producto);
    }







}
