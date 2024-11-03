package com.proyecto.SWL.Modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data //para crear setters and getters
@Entity //Esto es porque debemos inicializar todas las clases porque spring trabaja con anotaciones=@ o beans @entity es para decirle a spring que es una entidad principal
@Table(name = "Usuario") //y table es para decirle que es tabla de bases de datos
@NoArgsConstructor // constructor vacío o sin argumentos
@AllArgsConstructor // constructor que recibe un argumento por cada campo de la clase



//Modelo : Donde se modelan las clases con sus atributos
//Repositorio : Este pequete es para hacer la crud (DAO) se utiliza un repositorio para gestionar la persistencia y la recuperación de datos en una base de datos
//Servicio : se va a implementar los metodos de la crud
//Controlador : Encargado de pasar el servicio y poder visualizarlo en la interfaz



public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para que se cree solo el id y se genere automaticamente
    private Long idUsuario;
    private String nombre;
    private String email;
    private String contrasena;
    private Date fechaNacimiento;
    private String numeroDocumento;

    @ManyToOne(fetch = FetchType.LAZY) //Lazy es como una busqueda perezosa te trae la lista que tienen esa relacion, fecht = busqueda
    @JoinColumn(name = "idDocumento") // JoinColumn sirve para nombrar la columna de la relacion
    private TipoDocumentos tipoDocumento; // llamando el objecto

    @ManyToOne(fetch = FetchType.LAZY) //Lazy es como una busqueda perezosa te trae la lista que tienen esa relacion, fecht = busqueda
    @JoinColumn(name = "idRol") // JoinColumn sirve para nombrar la columna de la relacion
    private Roles roles; // llamando el objecto

    @ManyToOne(fetch = FetchType.LAZY) //Lazy es como una busqueda perezosa te trae la lista que tienen esa relacion, fecht = busqueda
    @JoinColumn(name = "idEstados") // JoinColumn sirve para nombrar la columna de la relacion
    private Estados estados; // llamando el objecto

    @ManyToOne(fetch = FetchType.LAZY) //Lazy es como una busqueda perezosa te trae la lista que tienen esa relacion, fecht = busqueda
    @JoinColumn(name = "idPaises") // JoinColumn sirve para nombrar la columna de la relacion
    private Paises paises; // llamando el objecto

    public void iniciarSesion(){}
    public void registrarUsuario(){}
    public void cerrarSesion(){}
}
