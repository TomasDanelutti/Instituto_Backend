package com.example.instiutoBackend.web.Curso;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Respuesta;
import com.example.instiutoBackend.service.Curso.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoControllerImpl implements CursoController{

    private final CursoService cursoService;

    @Override
    @GetMapping("/findBy/{pageNo}/{pageSize}")
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> findCursosPaginados(@PathVariable("pageNo") Integer pageNo,
                                           @PathVariable("pageSize") Integer pageSize) {
        return cursoService.findCursosPaginados(pageNo, pageSize);
    }

    @Override
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long count() {
        return cursoService.count();
    }

    @Override
    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Curso guardarCurso(@RequestBody Curso curso, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception("Datos incompletos");
        }
        cursoService.guardarCurso(curso);
        return null;
    }

    @Override
    @DeleteMapping("/{idCurso}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Respuesta eliminarCurso(@PathVariable Long idCurso) throws Exception {
       return cursoService.eliminarCurso(idCurso);
    }

    @Override
    @GetMapping("/findByNombre/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> findCursoByNombre(@PathVariable("nombre") String nombre) {
        return cursoService.findCursoByNombre(nombre);
    }

    @Override
    @GetMapping("/findNoInscriptos/{idUsuario}")
    public Set<Curso> findCursoNoInscriptosByUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return cursoService.findCursosNoInscriptosByUsuario(idUsuario);
    }

    @Override
    @GetMapping("/findInscriptos/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> findCursoInscriptosByUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return cursoService.findCursosInscriptosByUsuario(idUsuario);
    }

    @Override
    @GetMapping("/findAll/{activo}")
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> findAllByActivo(@PathVariable("activo") boolean activo) {
        return cursoService.findAllByActivo(activo);
    }
}
