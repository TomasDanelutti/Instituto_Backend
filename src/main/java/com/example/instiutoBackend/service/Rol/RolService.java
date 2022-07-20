package com.example.instiutoBackend.service.Rol;

import com.example.instiutoBackend.model.Rol;
import org.springframework.validation.BindingResult;

public interface RolService {

    Rol findRol(Number idRol, BindingResult result) throws Exception;

}
