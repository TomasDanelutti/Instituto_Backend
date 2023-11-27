package com.example.institutoBackend.service.Alumno;

import com.example.institutoBackend.dao.Alumno.AlumnoDao;
import com.example.institutoBackend.dao.Imagen.ImagenDao;
import com.example.institutoBackend.dao.Rol.RolDao;
import com.example.institutoBackend.dao.UsuarioLogin.UsuarioLoginDao;
import com.example.institutoBackend.model.Alumno;
import com.example.institutoBackend.model.Archivo;
import com.example.institutoBackend.model.Rol;
import com.example.institutoBackend.model.UsuarioLogin;
import com.example.institutoBackend.service.email.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
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
    public List<Alumno> getAlumnosPaginado(Integer pageNo, Integer pageSize, Optional<String> nombre) {
        Page<Alumno> alumnos;
        Pageable pagina = PageRequest.of(pageNo, pageSize);
        if (nombre.isPresent()) {
            alumnos =  alumnoDao.findAlumnosByNombreContainingIgnoreCase(nombre.get(), pagina);
        }
        else {
            alumnos = alumnoDao.findAll(pagina);
        }
        List<Alumno> listaAlumnos;
        listaAlumnos = alumnos.getContent();
        return listaAlumnos;
    }

    @Override
    public Long contarAlumnos(Optional<String> nombre) {
        Long cantidad;
        if (nombre.isPresent()) {
            cantidad = alumnoDao.countAlumnosByNombreContainingIgnoreCase(nombre.get());
        }
        else {
            cantidad = alumnoDao.countAlumnosBy();
        }
        return cantidad;
    }

    @Override
    public Alumno guardarAlumno(Alumno alumno) throws IOException {
        if (alumno.getIdPersona() != null) {
            // alumno.setUuid(UUID.randomUUID());
            Rol rol = new Rol();
            rol.setIdRol(0L);
            rol.setNombre("Alumno");
            alumno.setRol(rol);
            alumno.setActivo(true);
            UsuarioLogin usuarioLogin = new UsuarioLogin();
            usuarioLogin.setDni(alumno.getDni());
            usuarioLoginDao.save(usuarioLogin);
            mailService.sendMailCrearCuentaAlumno(alumno);
        }
        if (alumno.getImagen().getIdArchivo() == null) {
            Archivo archivo = new Archivo();
            imagenDao.save(archivo.setFotoUsuarioDefault());
            alumno.setImagen(archivo.setFotoUsuarioDefault());
        }
        else {
            imagenDao.save(alumno.getImagen());
        };
        alumnoDao.save(alumno);
        return alumno;
    }
}
