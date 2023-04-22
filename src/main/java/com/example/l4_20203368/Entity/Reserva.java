package com.example.l4_20203368.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;
@Getter
@Setter
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva")
    private int idreserva;

    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;

    @Column(name = "precio_total")
    private int precioTotal;

    @Column(name = "estado_pago")
    private String estadoPago;

    @ManyToOne
    @JoinColumn(name = "user_iduser")
    private  User user;

    @ManyToOne
    @JoinColumn(name = "vuelo_idvuelo")
    private Vuelo vuelo ;


}
