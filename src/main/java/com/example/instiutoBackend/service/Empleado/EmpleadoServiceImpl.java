package com.example.instiutoBackend.service.Empleado;

import com.example.instiutoBackend.dao.Empleado.EmpleadoDao;
import com.example.instiutoBackend.dao.Imagen.ImagenDao;
import com.example.instiutoBackend.model.Archivo;
import com.example.instiutoBackend.model.Empleado;
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
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoDao empleadoDao;

    private final ImagenDao imagenDao;

    @Override
    public List<Empleado> findEmpleadosPaginados(Integer pageNo, Integer pageSize) {
        Pageable pagina = PageRequest.of(pageNo, pageSize);
        Page<Empleado> administrativos = empleadoDao.findAll(pagina);
        return administrativos.getContent();
    }

    @Override
    public Long contarEmpleados() {
        return empleadoDao.count();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        if (empleado.getImagen() == null) {
            Archivo archivo = new Archivo();
            imagenDao.save(archivo.setFotoUsuarioDefault());
            empleado.setImagen(archivo.setFotoUsuarioDefault());
        }
        else {
            imagenDao.save(empleado.getImagen());
        }
        empleadoDao.save(empleado);
        return null;
    }

    @Override
    public List<Empleado> findEmpleadosByNombre(String nombre) {
        return empleadoDao.findEmpleadoByNombreIgnoreCase(nombre);
    }

    @Override
    public List<Empleado> findEmpleadosByPuesto(String puesto) {
        return empleadoDao.findEmpleadoByPuesto(puesto);
    }
}
