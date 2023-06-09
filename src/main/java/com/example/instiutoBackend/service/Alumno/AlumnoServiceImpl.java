package com.example.instiutoBackend.service.Alumno;

import com.example.instiutoBackend.dao.Alumno.AlumnoDao;
import com.example.instiutoBackend.dao.Imagen.ImagenDao;
import com.example.instiutoBackend.dao.Rol.RolDao;
import com.example.instiutoBackend.dao.UsuarioLogin.UsuarioLoginDao;
import com.example.instiutoBackend.model.*;
import com.example.instiutoBackend.model.EXTS.AlumnoEXTS;
import com.example.instiutoBackend.service.email.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoDao alumnoDao;

    private final RolDao rolDao;

    private final UsuarioLoginDao usuarioLoginDao;
    private final ImagenDao imagenDao;

    private final MailService mailService;
    @Override
    public List<Alumno> findAlumnosPaginados(Integer pageNo, Integer pageSize) {
        Pageable pagina = PageRequest.of(pageNo, pageSize);
        Page<Alumno> alumnos = alumnoDao.findAll(pagina);
        return alumnos.getContent();
    }

    @Override
    public Long contarALumnos() {
        return alumnoDao.count();
    }

    @Override
    public Alumno guardarAlumno(AlumnoEXTS alumno) throws IOException {
        if (alumno.getAlumno().getIdPersona() == null) {
            alumno.getAlumno().setUuid(UUID.randomUUID());
            Rol rol = new Rol();
            rol.setIdRol(0L);
            rol.setNombre("Alumno");
            alumno.getAlumno().setRol(rol);
            alumno.getAlumno().setActivo(true);
            UsuarioLogin usuarioLogin = new UsuarioLogin();
            usuarioLogin.setDni(alumno.getAlumno().getDni());
            usuarioLogin.setClave(alumno.getClave());
            usuarioLoginDao.save(usuarioLogin);
            mailService.sendMailCrearCuentaAlumno(alumno.getAlumno());
        }
        if (alumno.getAlumno().getImagen() == null) {
            Archivo archivo = new Archivo();
            imagenDao.save(archivo.setFotoUsuarioDefault());
            alumno.getAlumno().setImagen(archivo.setFotoUsuarioDefault());
        }
        else {
            imagenDao.save(alumno.getAlumno().getImagen());
        };
        System.out.println(alumno.getAlumno().getIdPersona());
        alumnoDao.save(alumno.getAlumno());
        return alumno.getAlumno();
    }

    @Override
    public List<Alumno> findALumnosByNombre(String nombre) {
        return alumnoDao.findAlumnosByNombreIgnoreCase(nombre);
    }
}
