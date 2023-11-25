package com.example.instiutoBackend.service.Inscripcion;

import com.example.instiutoBackend.dao.Alumno.AlumnoDao;
import com.example.instiutoBackend.dao.Curso.CursoDao;
import com.example.instiutoBackend.dao.Inscripcion.InscripcionDao;
import com.example.instiutoBackend.model.*;
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
    public Respuesta inscribirse(Long idCurso, Long idPersona) throws Exception {
        Persona persona = inscripcionDao.findAlumnoByCurso(idCurso, idPersona);
        Assert.isNull(persona, "No puedes inscribirte a este curso debido a que ya estas inscripto en el mismo. " +
                "Si crees que es un error contactate con Bedelia. Gracias");
        Curso curso = cursoDao.findCursoByIdCurso(idCurso);
        Assert.notNull(curso, "No hemos podido encontrar el curso.");
        Alumno alumno = alumnoDao.findAlumnoByIdPersona(idPersona);
        Assert.notNull(alumno, "No hemos podido encontrar el alumno.");
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setCurso(curso);
        inscripcion.setActivo(true);
        inscripcionDao.save(inscripcion);
        return new Respuesta(Estado.OK, "Te has inscripto correctamente al curso" + curso.getNombre());
    }

    @Override
    public Respuesta desinscribirse(Long idCurso, Long idPersona) throws Exception {
        Inscripcion inscripcion = inscripcionDao.findByCurso_IdCursoAndAlumno_IdPersona(idCurso, idPersona);
        Assert.notNull(inscripcion, "No hemos podido encontrar la inscripcion correspondiente");
        // inscripcion.setMotivoDesunscripcion(inscripcionDTO.getMotivo());
        inscripcion.setActivo(false);
        inscripcionDao.delete(inscripcion);
        return new Respuesta(Estado.OK, "el alumno " + inscripcion.getAlumno().getNombre() +
                " ha sido desinscripto del curso " + inscripcion.getCurso().getNombre() + " correctamente");
    }
}
