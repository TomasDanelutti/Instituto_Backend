package com.example.instiutoBackend.service.Programa;

import com.example.instiutoBackend.dao.Programa.ProgramaDao;
import com.example.instiutoBackend.model.Estado;
import com.example.instiutoBackend.model.Programa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgramaServiceImpl implements ProgramaService{

    private final ProgramaDao programaDao;

    @Override
    public List<Programa> findAll() {
        Estado estado = Estado.valueOf("ACTIVO");
        return programaDao.findProgramasByEstado(estado);
    }

    @Override
    public Programa guardarPrograma(Programa programa) throws Exception {
        programa.setEstado(Estado.valueOf("ACTIVO"));
        return programaDao.save(programa);
    }

    @Override
    public Programa elimnarPrograma(Programa programa) throws Exception {
        programa.setEstado(Estado.valueOf("INACTIVO"));
        return programaDao.save(programa);
    }

}
