package com.example.instiutoBackend.dao.Persona;

import com.example.instiutoBackend.model.Rol;
import com.example.instiutoBackend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonaDao extends JpaRepository<Persona, Long> {

    Persona findPersonaByDni(Long dni);

    List<Persona> findUsuarioByRolAndNombreContainingIgnoreCase(Rol rol, String nombre);

    List<Persona> findUsuariosByRol(Rol rol);

    boolean existsUsuariosByDni(Long dni);

    Persona findUsuarioByDni(Long dni);

    Persona findUsuarioByUuid(UUID uuid);

}
