package com.example.instiutoBackend.service.Curso;

import com.example.instiutoBackend.dao.Curso.CursoDao;
import com.example.instiutoBackend.dao.Imagen.ImagenDao;
import com.example.instiutoBackend.model.Archivo;
import com.example.instiutoBackend.model.Curso;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class CursoServiceImpl implements CursoService{

    private final CursoDao cursoDao;

    private final ImagenDao imagenDao;

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
    public void guardarCurso(Curso curso) throws Exception {
        if (curso.getImagen().getFoto() == null) {
            Archivo archivo = new Archivo();
            imagenDao.save(archivo.setFotoCursoDefault());
            curso.setImagen(archivo.setFotoCursoDefault());
        }
        else {
            imagenDao.save(curso.getImagen());
        }
        curso.setActivo(true);
        imagenDao.save(curso.getPrograma());
        cursoDao.save(curso);
    }

    @Override
    public void eliminarCurso(Long idCurso) throws Exception {
        Curso curso = cursoDao.findCursoByIdCurso(idCurso);
        cursoDao.delete(curso);
    }

    @Override
    public List<Curso> findCursoByNombre(String nombre) {
        return cursoDao.findCursosByNombreContainingIgnoreCase(nombre);
    }

    public List<Curso> findCursosInscriptosByUsuario(Long idUsuario) {
            return cursoDao.findCursoInscriptosByUsuario(idUsuario);
    }

    public Set<Curso> findCursosNoInscriptosByUsuario(Long idUsuario) {
//        List<Curso> cursos = cursoDao.findCursoNoInscriptosByUsuario(idUsuario);
//        System.out.println(cursos.size());
        return cursoDao.findCursoNoInscriptosByUsuario(idUsuario);
    }

    @Override
    public List<Curso> findAllByActivo(boolean activo) {
        return cursoDao.findAllByActivo(activo);
    }
}
