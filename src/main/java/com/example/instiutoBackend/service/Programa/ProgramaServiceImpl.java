package com.example.instiutoBackend.service.Programa;

import com.example.instiutoBackend.dao.Programa.ProgramaDao;
import com.example.instiutoBackend.model.Estado;
import com.example.instiutoBackend.model.Programa;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgramaServiceImpl implements ProgramaService{

    private final ProgramaDao programaDao;

    @Override
    public List<Programa> findProgramasPaginado(Integer pageNo, Integer pageSize) {
        Pageable pagina = PageRequest.of(pageNo, pageSize);
        Page<Programa> programas = programaDao.findAll(pagina);
        return programas.getContent();
    }

    @Override
    public Long count() {
        return programaDao.count();
    }

    @Override
    public List<Programa> findByNombre(String nombre) {
        return programaDao.findProgramaByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public Programa guardarPrograma(Programa programa) throws Exception {
        programa.setEstado(Estado.valueOf("ACTIVO"));
        return programaDao.save(programa);
    }

    @Override
    public void elimnarPrograma(Long idPrograma) throws Exception {
        Programa programa = programaDao.findProgramaByIdPrograma(idPrograma);
        programaDao.delete(programa);
    }

}
