package com.concre.crud.test.controller;

import com.concre.crud.test.entity.Producto;
import com.concre.crud.test.excepcion.ApiRequestException;
import com.concre.crud.test.service.ProductoSer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;



@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class controladorProducto {

    private final ProductoSer service;

    @GetMapping("/")
    public String home() {
        return "index"; // Devuelve el nombre de la vista
    }


    @PostMapping("/agregarProducto")
    public ResponseEntity<Producto>  agregarProducto(@RequestBody Producto producto) throws Exception {
        if (producto.getNombre().trim().isEmpty()) {
            throw new ApiRequestException("El nombre del producto es obligatorio y no puede estar vacío");
        }
        if (producto.getDescripcion().trim().isEmpty()) {
            throw new ApiRequestException("La descripción del producto es obligatoria y no puede estar vacía");
        }
        if (producto.getPrecio() <= 0) {
            throw new ApiRequestException("El precio del producto debe ser mayor que cero");
        }
        return ResponseEntity.ok(service.guardarProducto(producto));

    }
    @PostMapping("/agregarProductos")
    public ResponseEntity<List<Producto>> agregarProductos(@RequestBody List<Producto> productos){

        for(Producto producto: productos) {
            if (producto.getNombre().isEmpty()) {
                throw new ApiRequestException("El nombre del producto es  obligatorio, favor de ponerle un nombre ");
            }
            if (producto.getDescripcion().isEmpty()) {
                throw new ApiRequestException("El nombre de la descripcion es obligatoria, favor de ponerle una descripcion ");
            }
            if (producto.getPrecio() <= 0) {
                throw new ApiRequestException("Favor de ingresar un número válido, los números menores o igual a cero no son aceptados. ");
            }

        }
            //return service.guardarProductos(productos);
        return ResponseEntity.ok(service.guardarProductos(productos));
    }

    @GetMapping("/producto/")
    public ResponseEntity<List<Producto>> buscarProductos(){
        return ResponseEntity.ok(service.obtenerProducto());
    }

    @GetMapping("/productoPorId/{id}")
    public ResponseEntity<Producto> encontrarProductoId(@PathVariable int id){

        Producto producto = service.obtenerProductoPorId(id);
        if (id<= 0){
            throw new ApiRequestException("Favor de ingresar un ID Correcto");
        }
        if (producto != null ) {
            return ResponseEntity.ok(producto);
        }
        else {
            throw new ApiRequestException("El producto con ID:  " +id +" no se encontró en la base de datos",HttpStatus.NOT_FOUND);
        }
            //return ResponseEntity.ok(service.obtenerProductoPorId(id));
    }
    @GetMapping("/productoPorNombre/{nombre}")
    public ResponseEntity<Producto> encontrarProductoNombre(@PathVariable String nombre){
        if (nombre == null || nombre.isBlank()) {
            throw new ApiRequestException("El nombre del producto no puede estar vacío o ser nulo");
        }
        if (!nombre.matches("^[a-zA-Z]*$")) {
            throw new ApiRequestException("El nombre del producto solo puede contener letras");
        }
        Producto productoEncontrado = service.obtenerProductoPorNombre(nombre);
        if (productoEncontrado == null) {
            throw new ApiRequestException("No se encontró ningún producto con el nombre especificado: " + nombre);
        }
        return ResponseEntity.ok(service.obtenerProductoPorNombre(nombre));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto){
        validarProducto(producto);
        return ResponseEntity.ok(service.actualizarProducto(producto));

    }
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarProducto(@PathVariable int id){
        if (id <= 0) {
            throw new ApiRequestException("El ID del producto debe ser un número positivo");
        }
        return ResponseEntity.ok(service.borrarProducto(id));
    }

    private void validarProducto(Producto producto) {
        if (producto == null) {
            throw new ApiRequestException("El producto no puede ser nulo");
        }
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new ApiRequestException("El nombre del producto no puede estar vacío o ser nulo");
        }
        if (producto.getDescripcion() == null || producto.getDescripcion().trim().isEmpty()) {
            throw new ApiRequestException("La descripción del producto no puede estar vacía o ser nula");
        }
        if (producto.getPrecio() <= 0) {
            throw new ApiRequestException("El precio del producto debe ser un número válido y mayor que cero");
        }
    }

}
