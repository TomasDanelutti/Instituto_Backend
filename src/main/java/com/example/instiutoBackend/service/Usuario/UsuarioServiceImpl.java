package com.example.instiutoBackend.service.Usuario;

import com.example.instiutoBackend.dao.Rol.RolDao;
import com.example.instiutoBackend.dao.Usuario.UsuarioDao;
import com.example.instiutoBackend.model.Rol;
import com.example.instiutoBackend.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;

    private final RolDao rolDao;

    @Override
    public Usuario login(Long dni, String clave) throws Exception {
        Usuario usuario = usuarioDao.loginUser(dni, clave);

        if (usuario == null ) {
            throw new Exception("clave incorrecto.");
        }
        return usuario;
    }

    @Override
    public List<Usuario> findAlumnoByNombre(String nombre) {
        Rol rol = rolDao.findRolByIdRol(0L);
        return usuarioDao.findUsuarioByRolAndNombreContainingIgnoreCase(rol, nombre);
    }

    @Override
    public List<Usuario> findAlumnos() {;
        Rol rol = rolDao.findRolByIdRol(0L);
        return usuarioDao.findUsuariosByRol(rol);

    }

    @Override
    public Usuario guardarAlumno(Usuario usuario) throws Exception {
        Rol rol = rolDao.findRolByIdRol(0L);
        usuario.setRol(rol);
        return usuarioDao.save(usuario);
    }

    @Override
    public List<Usuario> findAdministrativoByNombre(String nombre) {
        Rol rol = rolDao.findRolByIdRol(1L);
        return usuarioDao.findUsuarioByRolAndNombreContainingIgnoreCase(rol, nombre);
    }

    @Override
    public List<Usuario> findAdministrativos() {
        Rol rol = rolDao.findRolByIdRol(1L);
        return usuarioDao.findUsuariosByRol(rol);
    }

    @Override
    public Usuario guardarAdministrativo(Usuario usuario) throws Exception {
        Rol rol = rolDao.findRolByIdRol(1L);
        usuario.setRol(rol);
        return usuarioDao.save(usuario);
    }
}
