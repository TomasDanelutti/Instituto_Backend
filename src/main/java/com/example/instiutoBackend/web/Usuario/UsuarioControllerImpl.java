package com.example.instiutoBackend.web.Usuario;

import com.example.instiutoBackend.model.Usuario;
import com.example.instiutoBackend.service.Usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioControllerImpl implements UsuarioController{

    private final UsuarioService usuarioService;

    @Override
    @GetMapping("/alumnos")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> findAlumnos() {
        return usuarioService.findAlumnos();
    }

    @Override
    @PostMapping("alumnos/guardar")
    @ResponseStatus(HttpStatus.OK)
    public Usuario guardarAlumno(@RequestBody  Usuario usuario, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception("Datos incompletos");
        }
        return usuarioService.guardarAlumno(usuario);
    }

    @Override
    @GetMapping("/administrativos")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> findAdministrativos() {
        return usuarioService.findAdministrativos();
    }

    @Override
    @PostMapping("administrativos/guardar")
    @ResponseStatus(HttpStatus.OK)
    public Usuario guardarAdministrativo(@RequestBody Usuario usuario, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception("Datos incompletos");
        }
        return usuarioService.guardarAdministrativo(usuario);
    }
}
