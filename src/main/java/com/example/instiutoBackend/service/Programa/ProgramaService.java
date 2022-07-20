package com.example.instiutoBackend.service.Programa;

import com.example.instiutoBackend.model.Programa;

import java.util.List;

public interface ProgramaService {
    List<Programa> findAll();

    Programa guardarPrograma(Programa programa) throws Exception;

    Programa elimnarPrograma(Programa programa) throws Exception;
}
