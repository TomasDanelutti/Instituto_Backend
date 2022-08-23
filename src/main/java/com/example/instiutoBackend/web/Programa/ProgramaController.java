package com.example.instiutoBackend.web.Programa;

import com.example.instiutoBackend.model.Programa;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ProgramaController {
    List<Programa> findAll();

    List<Programa> findByNombre(String nombre);

    Programa guardarPrograma(Programa programa, BindingResult result) throws Exception;

    Programa eliminarPrograma(Programa programa, BindingResult result) throws Exception;
}
