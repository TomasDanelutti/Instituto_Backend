package com.example.instiutoBackend.dao.NotificacionDesinscripcion;

import com.example.instiutoBackend.model.NotificacionDesinscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificacionDesinscripcionDao extends JpaRepository<NotificacionDesinscripcion, Long> {

    @Query("from NotificacionDesinscripcion nd where nd.estado = true")
    List<NotificacionDesinscripcion> findNotificacionesActivas();
}
