package com.example.l4_20203368.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter
@Setter
@Entity
public class Aerolinea {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idaerolinea")
    private int idaerolinea;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "codigo")
    private String codigo;


}
