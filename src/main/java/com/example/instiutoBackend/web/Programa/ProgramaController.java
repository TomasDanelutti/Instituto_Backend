package com.example.instiutoBackend.web.Programa;

import com.example.instiutoBackend.model.Programa;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ProgramaController {
    List<Programa> findProgramasPaginado(Integer pageNo, Integer pageSize);

    Long count();

    List<Programa> findByNombre(String nombre);

    Programa guardarPrograma(Programa programa, BindingResult result) throws Exception;

    void eliminarPrograma(Long idPrograma) throws Exception;
}
