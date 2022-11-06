package com.example.instiutoBackend.service.Empleado;

import com.example.instiutoBackend.dao.Empleado.EmpleadoDao;
import com.example.instiutoBackend.dao.Imagen.ImagenDao;
import com.example.instiutoBackend.dao.Rol.RolDao;
import com.example.instiutoBackend.model.Archivo;
import com.example.instiutoBackend.model.Empleado;
import com.example.instiutoBackend.model.Persona;
import com.example.instiutoBackend.model.Rol;
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
public class EmpleadoServiceImpl implements EmpleadoService {

    private final RolDao rolDao;

    private final EmpleadoDao empleadoDao;

    private final ImagenDao imagenDao;

    private final MailService mailService;

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
    public Empleado guardarEmpleado(Empleado empleado) throws IOException {
        if (empleado.getIdUsuario() == null) {
            String clave = Persona.cadenaAleatoria(8);
            mailService.sendMailGeneracionNuevaClave(empleado);
            empleado.setUuid(UUID.randomUUID());
        }
        if (empleado.getImagen().getFoto() == null) {
            Archivo archivo = new Archivo();
            imagenDao.save(archivo.setFotoUsuarioDefault());
            empleado.setImagen(archivo.setFotoUsuarioDefault());
        }
        else {
            imagenDao.save(empleado.getImagen());
        }
        Rol rol = new Rol();
        rol.setIdRol(1L);
        rol.setNombre("Administrativo");
        empleado.setRol(rol);
        empleado.setActivo(true);
        empleadoDao.save(empleado);
        return empleado;
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
