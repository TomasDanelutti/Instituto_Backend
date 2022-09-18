package com.example.instiutoBackend.service.Curso;

import com.example.instiutoBackend.dao.Curso.CursoDao;
import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Estado;
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
public class CursoServiceImpl implements CursoService{

    private final CursoDao cursoDao;

    @Override
    public List<Curso> findCursosPaginados(Integer pageNo, Integer pageSize) {
        Pageable pagina = PageRequest.of(pageNo, pageSize);
        Page<Curso> cursos = cursoDao.findAllBy(pagina);
        return cursos.getContent();
    }

    @Override
    public Long count() {
        return cursoDao.countCursosBy();
    }

    @Override
    public Curso guardarCurso(Curso curso) throws Exception {
       curso.setEstado(Estado.valueOf("ACTIVO"));
        return cursoDao.save(curso);
    }

    @Override
    public void eliminarCurso(Long idCurso) throws Exception {
        Curso curso = cursoDao.findCursoByIdCurso(idCurso);
//        curso.setEstado(Estado.valueOf("INACTIVO"));
        cursoDao.delete(curso);
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
