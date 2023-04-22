package com.example.l4_20203368.Repository;

import com.example.l4_20203368.Entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO reserva (fecha_reserva, precio_total, estado_pago, user_iduser, vuelo_idvuelo) VALUES (CURRENT_TIMESTAMP,?1, 'procesado',?2,?3)")
    void reservar(Integer precio, Integer iduser, Integer idvuelo);
}
