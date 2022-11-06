package com.example.instiutoBackend.web.Persona;

import java.io.IOException;

public interface PersonaController {

    String findAlumnoByDni(Long dni) throws IOException;

}
