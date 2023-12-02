package com.example.institutoBackend.dao.Persona;

import com.example.institutoBackend.model.Persona;
import com.example.institutoBackend.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaDao extends JpaRepository<Persona, Long> {

    Persona findPersonaByDni(Long dni);

    List<Persona> findUsuarioByRolAndNombreContainingIgnoreCase(Rol rol, String nombre);

    List<Persona> findUsuariosByRol(Rol rol);

    boolean existsUsuariosByDni(Long dni);


}
