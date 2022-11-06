package com.example.instiutoBackend.model.DTOS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificacionDesinscripcionDTO {

    private Long idAlumno;

    private Long idCurso;

    private Long idEmpleado;

    private String motivo;

    private boolean estado;
}
