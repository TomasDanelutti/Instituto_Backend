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
        NotificacionDesinscripcion notificacionDesinscripcion = new NotificacionDesinscripcion();
        Curso curso = cursoDao.findCursoByIdCurso(notificacionesDesinscripcionDTO.getIdCurso());
        Assert.notNull(curso, "Curso no encontrado.");
        Alumno alumno = alumnoDao.findAlumnoByIdUsuario(notificacionesDesinscripcionDTO.getIdAlumno());
        System.out.println(notificacionesDesinscripcionDTO);
        Assert.notNull(alumno, "Alumno no encontrado.");
        notificacionDesinscripcion.setAlumno(alumno);
        notificacionDesinscripcion.setCurso(curso);
        notificacionDesinscripcion.setMotivo(notificacionesDesinscripcionDTO.getMotivo());
        notificacionDesinscripcion.setEstado(true);
        notificacionDesinscripcionDao.save(notificacionDesinscripcion);
        return new Respuesta(Estado.OK,"Hemos recibido su solicitud de desinscripcion al curso "
                + curso.getNombre() + ". Recibiras un correo de confirmacion cuando se complete la desuscrición. Gracias");
    }

    @Override
    public Respuesta eliminarSolicitudDesinscripcion(Long idNotificacionesDescripcion) {
        return null;
    }
}
