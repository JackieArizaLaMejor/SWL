package com.proyecto.SWL.Modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "TipoDocumentos")
public class TipoDocumentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDocumento;
    private String nombre;

    @OneToMany(mappedBy = "tipoDocumento" , cascade = {CascadeType.MERGE,CascadeType.PERSIST}) // mappeBy es para busca el objecto , cascade = sirve para la crud esta relacion de merge y persist es para controlar las relaciones
    private Set<Usuario> usuario = new HashSet<>(); // Set =  Los elementos que almacenes en un Set no pueden ser duplicados HashSet = HashSet es una implementación de la interfaz Set que no garantiza el orden de los elementos, pero asegura que cada objeto sea único.

    @ManyToOne(fetch = FetchType.LAZY) //Lazy es como una busqueda perezosa te trae la lista que tienen esa relacion, fecht = busqueda
    @JoinColumn(name = "idEstados") // JoinColumn sirve para nombrar la columna de la relacion
    private Estados estados; // llamando el objecto


}
