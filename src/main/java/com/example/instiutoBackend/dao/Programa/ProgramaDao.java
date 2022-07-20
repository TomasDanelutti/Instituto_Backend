package com.example.instiutoBackend.dao.Programa;

import com.example.instiutoBackend.model.Estado;
import com.example.instiutoBackend.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramaDao extends JpaRepository<Programa, Long> {
    List<Programa> findProgramasByEstado(Estado estado);


    Programa findProgramaByIdPrograma(Long idPrograma);
}
