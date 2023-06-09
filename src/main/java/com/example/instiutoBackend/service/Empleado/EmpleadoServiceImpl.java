package com.example.instiutoBackend.service.Empleado;

import com.example.instiutoBackend.dao.Empleado.EmpleadoDao;
import com.example.instiutoBackend.dao.Imagen.ImagenDao;
import com.example.instiutoBackend.dao.Rol.RolDao;
import com.example.instiutoBackend.dao.UsuarioLogin.UsuarioLoginDao;
import com.example.instiutoBackend.model.*;
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

    private final UsuarioLoginDao usuarioLoginDao;

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
        if (empleado.getIdPersona() == null) {
            empleado.setUuid(UUID.randomUUID());
            Rol rol = new Rol();
            rol.setIdRol(1L);
            rol.setNombre("Administrativo");
            empleado.setRol(rol);
            empleado.setActivo(true);
            UsuarioLogin nuevoUsuarioLogin = new UsuarioLogin();
            nuevoUsuarioLogin.setDni(empleado.getDni());
            nuevoUsuarioLogin.setClave(Persona.cadenaAleatoria(8));
            usuarioLoginDao.save(nuevoUsuarioLogin);
            mailService.sendMailGeneracionClaveEmpleado(empleado,nuevoUsuarioLogin);
        }
        if (empleado.getImagen() == null) {
            Archivo archivo = new Archivo();
            imagenDao.save(archivo.setFotoUsuarioDefault());
            empleado.setImagen(archivo.setFotoUsuarioDefault());
        }
        else {
            imagenDao.save(empleado.getImagen());
        }
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
