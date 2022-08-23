package com.example.instiutoBackend.service.Curso;

import com.example.instiutoBackend.dao.Curso.CursoDao;
import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Estado;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CursoServiceImpl implements CursoService{

    private final CursoDao cursoDao;

    @Override
    public List<Curso> findAll() {
        Estado estado = Estado.valueOf("ACTIVO");
        return cursoDao.findCursosByEstado(estado);
    }

    @Override
    public Curso guardarCurso(Curso curso) throws Exception {
       curso.setEstado(Estado.valueOf("ACTIVO"));
        return cursoDao.save(curso);
    }

    @Override
    public Curso eliminarCurso(Curso curso) throws Exception {
        curso.setEstado(Estado.valueOf("INACTIVO"));
        return cursoDao.save(curso);
    }

    @Override
    public List<Curso> findCursoByNombre(String nombre) {
        return cursoDao.findCursosByNombreContainingIgnoreCase(nombre);
    }

    public List<Curso> findCursoInscriptosByUsuario(Long idUsuario) {
        List<Curso> cursos = cursoDao.findCursoInscriptosByUsuario(idUsuario);
            return cursoDao.findCursoInscriptosByUsuario(idUsuario);
    }

    public List<Curso> findCursoNoInscriptosByUsuario(Long idUsuario) {
        Estado estado = Estado.valueOf("ACTIVO");
        List<Curso> cursos = cursoDao.findCursosByEstado(estado);
        List<Curso> inscriptos = cursoDao.findCursoInscriptosByUsuario(idUsuario);
        inscriptos.forEach(inscripto -> {
            cursos.remove(inscripto);
        });
        return cursos;
    }
}
