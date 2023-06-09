package com.example.instiutoBackend.model.EXTS;

import com.example.instiutoBackend.model.Alumno;
import com.example.instiutoBackend.model.Persona;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlumnoEXTS {

    private Alumno alumno;

    private String clave;

}
