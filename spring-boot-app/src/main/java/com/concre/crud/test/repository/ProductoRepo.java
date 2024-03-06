package com.concre.crud.test.repository;

import com.concre.crud.test.entity.Producto;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Integer> {


    Producto findByNombre(String nombre);
}
