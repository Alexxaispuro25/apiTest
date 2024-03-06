package com.concre.crud.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String descripcion;
    private int precio;
    private int cantidad;
}
