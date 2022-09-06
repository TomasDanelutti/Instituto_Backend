package com.example.instiutoBackend.dao.Inscripcion;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Inscripcion;
import com.example.instiutoBackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InscripcionDao extends JpaRepository<Inscripcion, Long> {

    //@Query("from Inscripcion ins where ins.usuario = :idUsuario")

    @Query("from Usuario u inner join Inscripcion i on i.usuario.idUsuario = u.idUsuario where i.curso.idCurso = :idCurso")
    List<Usuario> findAlumnosByCurso(Long idCurso);

}

