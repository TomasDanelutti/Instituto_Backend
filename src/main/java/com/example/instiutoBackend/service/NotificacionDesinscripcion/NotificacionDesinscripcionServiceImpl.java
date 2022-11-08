package com.example.instiutoBackend.service.NotificacionDesinscripcion;

import com.example.instiutoBackend.dao.Alumno.AlumnoDao;
import com.example.instiutoBackend.dao.Curso.CursoDao;
import com.example.instiutoBackend.dao.NotificacionDesinscripcion.NotificacionDesinscripcionDao;
import com.example.instiutoBackend.model.*;
import com.example.instiutoBackend.model.DTOS.NotificacionDesinscripcionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificacionDesinscripcionServiceImpl implements NotificacionDesinscripcionService {

    private final NotificacionDesinscripcionDao notificacionDesinscripcionDao;

    private final CursoDao cursoDao;

    private final AlumnoDao alumnoDao;

    @Override
    public List<NotificacionDesinscripcion> findSolicitudesActivas() {
        return notificacionDesinscripcionDao.findNotificacionesActivas();
    }

    @Override
    public Respuesta guardarSolicitudDesinscripcion(NotificacionDesinscripcionDTO notificacionesDesinscripcionDTO) {
        NotificacionDesinscripcion notificacionDesinscripcionn = new NotificacionDesinscripcion();
        Assert.isNull(notificacionDesinscripcionn, "Ya has enviado una solicitud, poer favor espera a que sea respondida");
        Curso curso = cursoDao.findCursoByIdCurso(notificacionesDesinscripcionDTO.getIdCurso());
        Assert.notNull(curso, "Curso no encontrado.");
        Alumno alumno = alumnoDao.findAlumnoByIdUsuario(notificacionesDesinscripcionDTO.getIdAlumno());
        Assert.notNull(alumno, "Alumno no encontrado.");
        notificacionDesinscripcionn.setAlumno(alumno);
        notificacionDesinscripcionn.setCurso(curso);
        notificacionDesinscripcionn.setFechaCreacionNotificacion(new Date());
        notificacionDesinscripcionn.setMotivo(notificacionesDesinscripcionDTO.getMotivo());
        notificacionDesinscripcionn.setEstado(true);
        notificacionDesinscripcionDao.save(notificacionDesinscripcionn);
        return new Respuesta(Estado.OK,"Hemos recibido su solicitud de desinscripcion al curso "
                + curso.getNombre() + ". Recibiras un correo de confirmacion cuando se complete la desuscrición. Gracias");
    }

    @Override
    public Long contarNotificacionesDesinscripcionActivas() {
        return notificacionDesinscripcionDao.countAllByEstadoIsTrue();
    }

    @Override
    public Respuesta eliminarSolicitudDesinscripcion(Long idNotificacionesDescripcion) {
        return null;
    }
}
