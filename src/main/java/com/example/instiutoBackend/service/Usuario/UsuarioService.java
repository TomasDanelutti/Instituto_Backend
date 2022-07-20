package com.example.instiutoBackend.service.Usuario;

import com.example.instiutoBackend.model.Rol;
import com.example.instiutoBackend.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario login(Long dni, String clave) throws Exception;

    List<Usuario> findAlumnos();

    Usuario guardarAlumno(Usuario usuario) throws Exception;

    List<Usuario> findAdministrativos();

    Usuario guardarAdministrativo(Usuario usuario) throws Exception;
}
