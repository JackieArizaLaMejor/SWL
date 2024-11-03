package com.proyecto.SWL.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Paises")
public class Paises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPais;
    private String nombre;
    private String monedaPais;

    @OneToMany(mappedBy = "paises" , cascade = {CascadeType.MERGE,CascadeType.PERSIST}) // mappeBy es para busca el objecto , cascade = sirve para la crud esta relacion de merge y persist es para controlar las relaciones
    private Set<Usuario> usuario = new HashSet<>(); // Set =  Los elementos que almacenes en un Set no pueden ser duplicados HashSet = HashSet es una implementación de la interfaz Set que no garantiza el orden de los elementos, pero asegura que cada objeto sea único.

}
