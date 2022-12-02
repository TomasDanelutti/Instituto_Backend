package com.example.instiutoBackend.service.Alumno;

import com.example.instiutoBackend.dao.Alumno.AlumnoDao;
import com.example.instiutoBackend.dao.Imagen.ImagenDao;
import com.example.instiutoBackend.dao.Rol.RolDao;
import com.example.instiutoBackend.dao.UsuarioLogin.UsuarioLoginDao;
import com.example.instiutoBackend.model.*;
import com.example.instiutoBackend.model.EXTS.AlumnoEXTS;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
    public Alumno guardarAlumno(AlumnoEXTS alumno) {
        Alumno alumno1 ;
        if (alumno.getImagen() == null) {
            Archivo archivo = new Archivo();
            imagenDao.save(archivo.setFotoUsuarioDefault());
            alumno.setImagen(archivo.setFotoUsuarioDefault());
//            usuarioLoginDao.save(usuarioLogin);
        }
        else {
            imagenDao.save(alumno.getImagen());
        };
        if (alumno.getIdUsuario() == null) {
            alumno.setUuid(UUID.randomUUID());
        }
        Rol rol = new Rol();
        rol.setIdRol(0L);
        rol.setNombre("Alumno");
        alumno.setRol(rol);
        alumno.setActivo(true);
        alumnoDao.save(alumno);
        return alumno;
    }

    @Override
    public List<Alumno> findALumnosByNombre(String nombre) {
        return alumnoDao.findAlumnosByNombreIgnoreCase(nombre);
    }
}
