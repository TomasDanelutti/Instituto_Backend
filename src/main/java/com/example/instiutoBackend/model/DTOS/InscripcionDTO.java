package com.example.instiutoBackend.model.DTOS;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscripcionDTO {

    @NotNull
    private Long idCurso;

    @NotNull
    private Long idPersona;

    @NotNull
    private String motivo;
}
