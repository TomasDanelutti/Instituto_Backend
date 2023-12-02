package com.example.institutoBackend.service.Curso;

import com.example.institutoBackend.dao.Curso.CursoDao;
import com.example.institutoBackend.dao.Imagen.ImagenDao;
import com.example.institutoBackend.model.Archivo;
import com.example.institutoBackend.model.Curso;
import com.example.institutoBackend.model.Estado;
import com.example.institutoBackend.model.Respuesta;
import com.example.institutoBackend.service.Persona.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    private final PersonaService personaService;

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

    @Override
    public List<Curso> findCursosByUsuarioAndNombre( Optional<String> nombre, boolean inscripto, Integer numPage, Integer pageSize) {
        Pageable paging = PageRequest.of(numPage, pageSize, Sort.by("idCurso"));
        Page<Curso> cursos;
        if (inscripto) {
            if (nombre.isPresent()) {
                cursos = cursoDao.findCursoInscriptosByPersonaAndNombre(personaService.getPersonaSession().getIdPersona(), nombre.get(), paging);
            }
            else {
                cursos = cursoDao.findCursoInscriptosByPersona(personaService.getPersonaSession().getIdPersona(), paging);
            }
        }
        else {
            if (nombre.isPresent()) {
                cursos = cursoDao.findCursoNoInscriptosByPersonaAndNombre(personaService.getPersonaSession().getIdPersona(), nombre.get(), paging);
            }
            else {
                cursos = cursoDao.findCursoNoInscriptosByPersona(personaService.getPersonaSession().getIdPersona(), paging);
            }
        }
        List<Curso> listaCursos;
        listaCursos = cursos.getContent();
        return listaCursos;
    }

    @Override
    public Long countCursosByUsuarioAndNombre(Optional<String> nombre, boolean inscripto) {
        Long cantidad;
        if (inscripto) {
            if (nombre.isPresent()) {
                cantidad = cursoDao.countCursoInscriptosByPersonaAndNombre(personaService.getPersonaSession().getIdPersona(), nombre.get());
            }
            else {
                cantidad = cursoDao.countCursoInscriptosByPersona(personaService.getPersonaSession().getIdPersona());
            }
        }
        else {
            if (nombre.isPresent()) {
                cantidad = cursoDao.countCursoNoInscriptosByPersonaAndNombre(personaService.getPersonaSession().getIdPersona(), nombre.get());
            }
            else {
                cantidad = cursoDao.countCursoNoInscriptosByPersona(personaService.getPersonaSession().getIdPersona());
            }
        }
        return cantidad;
    }
}
