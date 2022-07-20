package com.example.instiutoBackend.web.Usuario;

import com.example.instiutoBackend.model.Usuario;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface UsuarioController {


    List<Usuario> findAlumnos();

    Usuario guardarAlumno(Usuario usuario, BindingResult result) throws Exception;

    List<Usuario> findAdministrativos();

    Usuario guardarAdministrativo(Usuario usuario, BindingResult result) throws Exception;
}
