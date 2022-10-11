package com.example.instiutoBackend.service.Inscripcion;

import com.example.instiutoBackend.dao.Alumno.AlumnoDao;
import com.example.instiutoBackend.dao.Curso.CursoDao;
import com.example.instiutoBackend.dao.Inscripcion.InscripcionDao;
import com.example.instiutoBackend.dao.Usuario.UsuarioDao;
import com.example.instiutoBackend.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InscripcionServiceImpl implements InscripcionService {

    private final InscripcionDao inscripcionDao;

    private final CursoDao cursoDao;

    private final AlumnoDao alumnoDao;

    @Override
    public Inscripcion inscribirse(InscripcionDTO inscripcionDTO) throws Exception {
        Curso curso = cursoDao.findCursoByIdCurso(inscripcionDTO.getIdCurso());
        if (curso.getIdCurso() == null) {
            throw new Exception("Curso no encontrado");
        }
        Alumno alumno = alumnoDao.findAlumnoByIdUsuario(inscripcionDTO.getIdUsuario());
        if (alumno == null) {
            throw new Exception("Alumno no encontrado");
        }
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setCurso(curso);
        inscripcion.setEstado(Estado.ACTIVO);
        inscripcionDao.save(inscripcion);
        return null;
    }

    @Override
    public List<Usuario> findAlumnosByCurso(Long idCurso) {
        return inscripcionDao.findAlumnosByCurso(idCurso);
    }
}
