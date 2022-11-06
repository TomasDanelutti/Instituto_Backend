package com.example.instiutoBackend.dao.Inscripcion;

import com.example.instiutoBackend.model.Inscripcion;
import com.example.instiutoBackend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface InscripcionDao extends JpaRepository<Inscripcion, Long> {

//    @Query("from Inscripcion ins where ins.alumno = :idUsuario")

    @Query("from Persona u inner join Inscripcion i on i.alumno.idUsuario = u.idUsuario where i.curso.idCurso = :idCurso")
    List<Persona> findAlumnosByCurso(Long idCurso);

}

