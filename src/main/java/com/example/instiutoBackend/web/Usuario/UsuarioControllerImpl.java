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


}
