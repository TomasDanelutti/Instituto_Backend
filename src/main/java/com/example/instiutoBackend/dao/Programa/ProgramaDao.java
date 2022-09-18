package com.example.instiutoBackend.dao.Programa;

import com.example.instiutoBackend.model.Programa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramaDao extends JpaRepository<Programa, Long> {
    List<Programa> findProgramaByNombreContainingIgnoreCase(String nombre);

    Programa findProgramaByIdPrograma(Long idPrograma);

    Page<Programa> findAllBy(Pageable page);

    Long countProgramasBy();
}
