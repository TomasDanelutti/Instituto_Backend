package com.example.instiutoBackend.service.Programa;

import com.example.instiutoBackend.model.Programa;

import java.util.List;

public interface ProgramaService {
    List<Programa> findProgramasPaginado(Integer pageNo, Integer pageSize);

    Long count();

    List<Programa> findByNombre(String nombre);

    Programa guardarPrograma(Programa programa) throws Exception;

    void elimnarPrograma(Long idPrograma) throws Exception;
}
