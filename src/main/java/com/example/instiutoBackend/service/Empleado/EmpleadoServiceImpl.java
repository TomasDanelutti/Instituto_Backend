package com.example.instiutoBackend.service.Empleado;

import com.example.instiutoBackend.dao.Empleado.EmpleadoDao;
import com.example.instiutoBackend.dao.Imagen.ImagenDao;
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

    private final EmpleadoDao administrativoDao;

    private final ImagenDao imagenDao;

    @Override
    public List<Empleado> findEmpleadosPaginados(Integer pageNo, Integer pageSize) {
        Pageable pagina = PageRequest.of(pageNo, pageSize);
        Page<Empleado> administrativos = administrativoDao.findAll(pagina);
        return administrativos.getContent();
    }

    @Override
    public Long contarEmpleados() {
        return administrativoDao.count();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        imagenDao.save(empleado.getImagen());
        return administrativoDao.save(empleado);
    }

    @Override
    public List<Empleado> findEmpleadosByNombre(String nombre) {
        return administrativoDao.findEmpleadoByNombreIgnoreCase(nombre);
    }
}
