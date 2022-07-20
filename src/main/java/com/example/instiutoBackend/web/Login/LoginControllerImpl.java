package com.example.instiutoBackend.web.Login;

import com.example.instiutoBackend.dao.Usuario.UsuarioDao;
import com.example.instiutoBackend.model.Usuario;
import com.example.instiutoBackend.service.Usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController{
    private final UsuarioService usuarioService;

    @Override
    @GetMapping("/{dni}/{clave}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario findByDniAndClave(@PathVariable("dni") Long dni,
                                     @PathVariable("clave") String clave) throws Exception {
        return usuarioService.login(dni, clave);
    }
}
