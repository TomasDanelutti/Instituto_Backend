package com.example.instiutoBackend.service.Inscripcion;

import com.example.instiutoBackend.dao.Alumno.AlumnoDao;
import com.example.instiutoBackend.dao.Curso.CursoDao;
import com.example.instiutoBackend.dao.Inscripcion.InscripcionDao;
import com.example.instiutoBackend.model.*;
import com.example.instiutoBackend.model.DTOS.InscripcionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InscripcionServiceImpl implements InscripcionService {

    private final InscripcionDao inscripcionDao;

    private final CursoDao cursoDao;

    private final AlumnoDao alumnoDao;

    @Override
    public Respuesta inscribirse(InscripcionDTO inscripcionDTO) throws Exception {
        Curso curso = cursoDao.findCursoByIdCurso(inscripcionDTO.getIdCurso());
        Assert.notNull(curso, "No hemos podido encontrar el curso.");
        Alumno alumno = alumnoDao.findAlumnoByIdUsuario(inscripcionDTO.getIdUsuario());
        Assert.notNull(alumno, "No hemos podido encontrar el alumno.");
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setCurso(curso);
        inscripcion.setActivo(true);
        inscripcionDao.save(inscripcion);
        return new Respuesta(Estado.OK, "Te has inscripto correctamente al curso" + curso.getNombre());
    }

    @Override
    public Respuesta desinscribirse(InscripcionDTO inscripcionDTO) throws Exception {
        Curso curso = cursoDao.findCursoByIdCurso(inscripcionDTO.getIdCurso());
        Assert.notNull(curso, "No hemos podido encontrar el curso.");
        Alumno alumno = alumnoDao.findAlumnoByIdUsuario(inscripcionDTO.getIdUsuario());
        Assert.notNull(alumno, "No hemos podido encontrar el alumno.");
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setCurso(curso);
        inscripcion.setMotivoDesunscripcion(inscripcionDTO.getMotivo());
        inscripcion.setActivo(false);
        inscripcionDao.save(inscripcion);
        return new Respuesta(Estado.OK, "el alumno" + alumno.getNombre() +
                "ha sido desinscripto del curso" + curso.getNombre() + "correctamente");
    }


    @Override
    public List<Persona> findAlumnosByCurso(Long idCurso) {
        return inscripcionDao.findAlumnosByCurso(idCurso);
    }

}
