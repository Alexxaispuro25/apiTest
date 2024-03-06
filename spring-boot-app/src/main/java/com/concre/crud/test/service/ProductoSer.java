package com.concre.crud.test.service;

import com.concre.crud.test.entity.Producto;
import com.concre.crud.test.repository.ProductoRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoSer {

    private final ProductoRepo repository;

    public Producto guardarProducto(Producto producto){
        //return repository.save(producto);
        if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        return repository.save(producto);

    }

    public List<Producto> guardarProductos(List<Producto> productos){
        return repository.saveAll(productos);

    }

    public List<Producto> obtenerProducto(){
        return repository.findAll();
    }
    public Producto obtenerProductoPorId(int id){
        return repository.findById(id).orElse(null);
    }
    public Producto obtenerProductoPorNombre(String nombre){
        return repository.findByNombre(nombre);
    }
    public String borrarProducto(int id){
        repository.deleteById(id);
        return "producto eliminado : "+id;
    }

    public Producto actualizarProducto(Producto producto){
        Producto productoExistente = repository.findById(producto.getId()).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setPrecio(producto.getPrecio());
        return repository.save(productoExistente);
    }
}
