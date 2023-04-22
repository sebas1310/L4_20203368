package com.example.l4_20203368.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;
@Setter
@Getter
@Entity
public class Vuelo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idvuelo")
    private int idvuelo;

    @Column(name = "origen")
    private String origen;

    @Column(name = "destino")
    private String destino;

    @Column(name = "fecha_salida")
    private Timestamp fechaSalida;

    @Column(name = "fecha_llegada")
    private Timestamp fechaLlegada;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "precio")
    private int precio;

    @ManyToOne
    @JoinColumn(name = "aerolinea_idaerolinea")
    private Aerolinea aerolinea;

    @Column(name = "asientos_disponibles")
    private int asientosDisponibles;

    @Column(name = "descripcion")
    private String descripcion;


}
