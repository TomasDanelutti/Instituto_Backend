package com.example.instiutoBackend.service.Inscripcion;

import com.example.instiutoBackend.dao.Inscripcion.InscripcionDao;
import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Inscripcion;
import com.example.instiutoBackend.model.Rol;
import com.example.instiutoBackend.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InscripcionServiceImpl implements InscripcionService {

    private final InscripcionDao inscripcionDao;

    @Override
    public Inscripcion inscribirse(Inscripcion inscripcion) throws Exception {
        return inscripcionDao.save(inscripcion);
    }

    @Override
    public List<Usuario> findAlumnosByCurso(Long idCurso) {
        return inscripcionDao.findAlumnosByCurso(idCurso);
    }
}
