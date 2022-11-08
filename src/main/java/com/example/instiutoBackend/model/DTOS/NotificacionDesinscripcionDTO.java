package com.example.instiutoBackend.model.DTOS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificacionDesinscripcionDTO {

    private Long idAlumno;

    private Long idCurso;

    private Long idEmpleado;

    private Date fechaCreacionNotificacion;

    private String motivo;

    private boolean estado;

    private String token;
}
