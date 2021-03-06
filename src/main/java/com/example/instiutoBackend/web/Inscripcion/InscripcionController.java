package com.example.instiutoBackend.web.Inscripcion;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Inscripcion;
import com.example.instiutoBackend.model.Usuario;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface InscripcionController {

    Inscripcion inscribirse(Inscripcion inscripcion, BindingResult result) throws Exception;
}
