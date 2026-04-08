package com.example.SistemaDeProductosdemo.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {

    @NotNull
    private Integer id;

    @NotBlank
    private String nombre;

    @NotNull
    private Double precio;

    @NotNull
    private Boolean disponible;
    
}