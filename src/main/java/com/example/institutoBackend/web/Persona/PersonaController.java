package com.example.institutoBackend.web.Persona;

import java.io.IOException;

public interface PersonaController {

    String findAlumnoByDni(Long dni) throws IOException;

}
