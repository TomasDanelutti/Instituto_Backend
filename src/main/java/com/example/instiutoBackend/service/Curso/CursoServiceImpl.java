package com.example.instiutoBackend.service.Curso;

import com.example.instiutoBackend.dao.Curso.CursoDao;
import com.example.instiutoBackend.dao.Imagen.ImagenDao;
import com.example.instiutoBackend.model.Archivo;
import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Estado;
import com.example.instiutoBackend.model.Respuesta;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CursoServiceImpl implements CursoService{

    private final CursoDao cursoDao;

    private final ImagenDao imagenDao;

    @Override
    public List<Curso> GetCursosPaginado(Integer pageNo, Integer pageSize, Optional<String> nombre) {
        Page<Curso> cursos;
        Pageable pagina = PageRequest.of(pageNo, pageSize);
        if (nombre.isPresent()) {
            cursos = cursoDao.findCursosByNombreContainingIgnoreCase(pagina, nombre.get());
        }
        else {
            cursos = cursoDao.findAllBy(pagina);
        }
        List<Curso> listaCursos;
        listaCursos = cursos.getContent();
        return listaCursos;
    }

    @Override
    public Long countCursos(Optional<String> nombre) {
        Long cantidad;
        if (nombre.isPresent()) {
            cantidad = cursoDao.countCursosByNombreContainingIgnoreCase(nombre.get());
        }
        else {
            cantidad = cursoDao.countCursosBy();
        }
        return cantidad;
    }

    @Override
    public Curso guardarCurso(Curso curso) throws Exception {
        if (curso.getImagen().getIdArchivo() == null) {
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
        return curso;
    }

    @Override
    public Respuesta eliminarCurso(Long idCurso) throws Exception {
        Curso curso = cursoDao.findCursoByIdCurso(idCurso);
        cursoDao.delete(curso);
        return new Respuesta(Estado.OK,"El curso" + curso.getNombre() + "ha sido eliminado correctamente");
    }

    public List<Curso> findCursosInscriptosByUsuario(Long idPersona) {
            return cursoDao.findCursoInscriptosByPersona(idPersona);
    }

    public List<Curso> findCursosNoInscriptosByUsuario(Long idPersona) {
        List<Curso> cursos = cursoDao.findAll();
        List<Curso> cursosInscriptos = cursoDao.findCursoInscriptosByPersona(idPersona);
        cursos.removeAll(cursosInscriptos);
        return cursoDao.findCursoNoInscriptosByPersona(idPersona);
    }

    @Override
    public List<Curso> findAllByActivo(boolean activo) {
        return cursoDao.findAllByActivo(activo);
    }

    @Override
    public List<Curso> findCursosInscriptosByUsuarioAndNombre(Long idUsuario, Optional<String> nombre) {
        return null;
    }

    @Override
    public List<Curso> findCursosNoInscriptosByUsuarioAndNombre(Long idUsuario, Optional<String> nombre) {
        return null;
    }
}
