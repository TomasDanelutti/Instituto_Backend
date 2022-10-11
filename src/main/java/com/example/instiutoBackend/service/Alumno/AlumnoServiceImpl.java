package com.example.instiutoBackend.service.Alumno;

import com.example.instiutoBackend.dao.Alumno.AlumnoDao;
import com.example.instiutoBackend.dao.Imagen.ImagenDao;
import com.example.instiutoBackend.model.Alumno;
import com.example.instiutoBackend.model.Archivo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoDao alumnoDao;

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
    public Alumno guardarAlumno(Alumno alumno) {
        if (alumno.getImagen() == null) {
            Archivo archivo = new Archivo();
            imagenDao.save(archivo.setFotoUsuarioDefault());
            alumno.setImagen(archivo.setFotoUsuarioDefault());
        }
        else {
            imagenDao.save(alumno.getImagen());
        };
        alumnoDao.save(alumno);
        return null;
    }

    @Override
    public List<Alumno> findALumnosByNombre(String nombre) {
        return alumnoDao.findAlumnosByNombreIgnoreCase(nombre);
    }
}
