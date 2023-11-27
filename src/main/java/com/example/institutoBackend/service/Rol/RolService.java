package com.example.institutoBackend.service.Rol;

import com.example.institutoBackend.model.Rol;
import org.springframework.validation.BindingResult;

public interface RolService {

    Rol findRol(Number idRol, BindingResult result) throws Exception;

}
