package com.example.instiutoBackend.service.Desinscripcion;

import com.example.instiutoBackend.dao.Alumno.AlumnoDao;
import com.example.instiutoBackend.dao.Curso.CursoDao;
import com.example.instiutoBackend.dao.Desinscripcion.DesinscripcionDao;
import com.example.instiutoBackend.dao.Empleado.EmpleadoDao;
import com.example.instiutoBackend.dao.Persona.PersonaDao;
import com.example.instiutoBackend.model.*;
import com.example.instiutoBackend.model.DTOS.DesinscripcionDTO;
import com.example.instiutoBackend.service.Empleado.EmpleadoService;
import com.example.instiutoBackend.service.email.MailService;
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
    public void getToken(DesinscripcionDTO desinscripcionDTO) throws IOException {
        Desinscripcion desinscripcionBD = desinscripcionDao.findDesinscripcionByAlumno_IdUsuarioAndCurso_IdCursoAAndEstadoIsTrue(desinscripcionDTO.getIdAlumno(), desinscripcionDTO.getIdCurso());
        Assert.isNull(desinscripcionBD, "Ya has enviado una solicitud, por favor espera a que sea respondida");
        Curso curso = cursoDao.findCursoByIdCurso(desinscripcionDTO.getIdCurso());
        System.out.println(desinscripcionDTO);
        System.out.println(curso);
        Assert.notNull(curso, "Curso no encontrado.");
        Alumno alumno = alumnoDao.findAlumnoByIdUsuario(desinscripcionDTO.getIdAlumno());
        Assert.notNull(alumno, "Alumno no encontrado.");
        Desinscripcion desinscripcion = new Desinscripcion();
        desinscripcion.setAlumno(alumno);
        desinscripcion.setCurso(curso);
        desinscripcion.setFechaCreacionDesinscripcion(new Date());
        desinscripcion.setMotivo(desinscripcionDTO.getMotivo());
        desinscripcion.setEstado(true);
        desinscripcion.setToken(Persona.cadenaAleatoria(10));
        mailService.sendMailGeneraionTokenDesinscripcion(desinscripcion);
        desinscripcionDao.save(desinscripcion);
    }

    @Override
    public Respuesta guardarDesinscripcion(DesinscripcionDTO desinscripcionDTO) {
        Desinscripcion desinscripcionBD = desinscripcionDao.findDesinscripcionByAlumno_IdUsuarioAndCurso_IdCursoAAndEstadoIsTrue(desinscripcionDTO.getIdAlumno(), desinscripcionDTO.getIdCurso());
        if (desinscripcionDTO.getToken() != null) {
            System.out.println(desinscripcionDTO.getToken());
            System.out.println(desinscripcionBD.getToken());
            if (desinscripcionDTO.getToken().equals(desinscripcionBD.getToken())) {
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
    public Respuesta cancelarDescripcion(DesinscripcionDTO desinscripcionDTO) throws IOException {
        Desinscripcion desinscripcionBD = desinscripcionDao.findDesinscripcionByAlumno_IdUsuarioAndCurso_IdCursoAAndEstadoIsTrue(desinscripcionDTO.getIdAlumno(), desinscripcionDTO.getIdCurso());
        Empleado empleado = empleadoDao.findByIdUsuario(desinscripcionDTO.getIdEmpleado());
        Assert.notNull(empleado, "Error de seguridad. Solo los empleados pueden realizar esta acción");
        desinscripcionBD.setMotivo(desinscripcionDTO.getMotivo());
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
