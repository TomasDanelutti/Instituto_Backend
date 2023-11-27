package com.example.institutoBackend.service.Desinscripcion;

import com.example.institutoBackend.dao.Alumno.AlumnoDao;
import com.example.institutoBackend.dao.Curso.CursoDao;
import com.example.institutoBackend.dao.Desinscripcion.DesinscripcionDao;
import com.example.institutoBackend.dao.Empleado.EmpleadoDao;
import com.example.institutoBackend.model.*;
import com.example.institutoBackend.service.email.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DesinscripcionServiceImpl implements DesinscripcionService {

    private final DesinscripcionDao desinscripcionDao;

    private final CursoDao cursoDao;

    private final AlumnoDao alumnoDao;

    private final MailService mailService;

    private final EmpleadoDao empleadoDao;

    @Override
    public List<Desinscripcion> findSolicitudesActivas() {
        return desinscripcionDao.findNotificacionesActivas();
    }

    @Override
    public void getToken(Long idCurso, Long idAlumno, String motivo) throws IOException {
        Desinscripcion desinscripcionBD = desinscripcionDao.findDesinscripcionByAlumno_IdPersonaAndCurso_IdCursoAAndEstadoIsTrue(idAlumno, idCurso);
        Assert.isNull(desinscripcionBD, "Ya has enviado una solicitud, por favor espera a que sea respondida");
        Curso curso = cursoDao.findCursoByIdCurso(idCurso);
        Assert.notNull(curso, "Curso no encontrado.");
        Alumno alumno = alumnoDao.findAlumnoByIdPersona(idAlumno);
        Assert.notNull(alumno, "Alumno no encontrado.");
        Desinscripcion desinscripcion = new Desinscripcion();
        desinscripcion.setAlumno(alumno);
        desinscripcion.setCurso(curso);
        desinscripcion.setFechaCreacionDesinscripcion(new Date());
        desinscripcion.setMotivo(motivo);
        desinscripcion.setEstado(true);
        desinscripcion.setToken(Persona.cadenaAleatoria(10));
        mailService.sendMailGeneraionTokenDesinscripcion(desinscripcion);
        desinscripcionDao.save(desinscripcion);
    }

    @Override
    public Respuesta guardarDesinscripcion(Long idCurso, Long idALumno, String motivo, String token) {
        Desinscripcion desinscripcionBD = desinscripcionDao.findDesinscripcionByAlumno_IdPersonaAndCurso_IdCursoAAndEstadoIsTrue(idALumno, idCurso);
        if (desinscripcionBD == null) {
            return new Respuesta(Estado.ERROR, "No hemos encontrado la solicitud de desinscripcion. Por favor cree una nueva");
        }
        if (token != null) {
            if (token.toString().equals(desinscripcionBD.getToken())) {
                desinscripcionDao.save(desinscripcionBD);
                return new Respuesta(Estado.OK, "Hemos recibido la solicitud de desinscripción al curso. " +
                        "Un administrativo lo vera proximamente. Recibiras un correo con la resolución. Muchas gracias");
            }
            else {
                desinscripcionDao.delete(desinscripcionBD);
                return new Respuesta(Estado.ERROR, "El token ingresado es invalido. Por favor cree otra solicitud");
            }
        }
        else {
            desinscripcionDao.delete(desinscripcionBD);
            return new Respuesta(Estado.ERROR, "El token ingresado es invalido. Por favor cree otra solicitud");
        }
    }

    @Override
    public Long contarDesinscripcionesActivas() {
        return desinscripcionDao.countAllByEstadoIsTrue();
    }

    @Override
    public Respuesta cancelarDescripcion(Long idAlumno, Long idEmpleado, Long idCurso, String motivo) throws IOException {
        Desinscripcion desinscripcionBD = desinscripcionDao.findDesinscripcionByAlumno_IdPersonaAndCurso_IdCursoAAndEstadoIsTrue(idAlumno, idCurso);
        Empleado empleado = empleadoDao.findByIdPersona(idEmpleado);
        Assert.notNull(empleado, "Error de seguridad. Solo los empleados pueden realizar esta acción");
        desinscripcionBD.setMotivo(motivo);
        desinscripcionBD.setEstado(false);
        desinscripcionBD.setEmpleado(empleado);
        desinscripcionDao.save(desinscripcionBD);
        mailService.cancelarDesinscripcion(desinscripcionBD);
        return new Respuesta(Estado.OK, "La desinscripcion ha sido cancelada correctamente," +
                " Hemos enviado un correo al alumno informandole el motivo");
    }

    @Override
    public Respuesta eliminarDesinscripcion(Long idNotificacionesDescripcion) {
        return null;
    }
}
