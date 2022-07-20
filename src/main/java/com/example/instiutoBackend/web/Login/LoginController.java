package com.example.instiutoBackend.web.Login;

import com.example.instiutoBackend.model.Usuario;

public interface LoginController {

    Usuario findByDniAndClave(Long dni, String clave) throws Exception;
}
