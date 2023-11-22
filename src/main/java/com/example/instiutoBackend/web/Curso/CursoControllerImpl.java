package com.example.instiutoBackend.web.Curso;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.model.Respuesta;
import com.example.instiutoBackend.service.Curso.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoControllerImpl implements CursoController{

    private final CursoService cursoService;

    @Override
    @GetMapping("/getCursosPaginado")
    public List<Curso> GetCursosPaginado(@RequestParam("pageNo") Integer pageNo,
                                         @RequestParam("pageSize") Integer pageSize,
                                         @RequestParam("nombre") Optional<String> nombre) {
        return cursoService.GetCursosPaginado(pageNo, pageSize, nombre);
    }

    @Override
    @GetMapping("/count")
    public Long countCursos(@RequestParam("nombre") Optional<String> nombre) {
        return cursoService.countCursos(nombre);
    }

    @Override
    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Curso guardarCurso(@RequestBody @Valid Curso curso, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception("Datos incompletos");
        }
        return cursoService.guardarCurso(curso);
    }

    @Override
    @DeleteMapping("/{idCurso}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Respuesta eliminarCurso(@PathVariable Long idCurso) throws Exception {
       return cursoService.eliminarCurso(idCurso);
    }

    @Override
    @GetMapping("/findNoInscriptos/{idUsuario}")
    public List<Curso> findCursoNoInscriptosByUsuario(@PathVariable("idUsuario") Long idUsuario) {
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

    @Override
    @GetMapping
    public List<Curso> findCursosInscriptosByUsuarioAndNombre(
            @RequestParam("idUsuario") Long idUsuario,
            @RequestParam("nombre") Optional<String> nombre) {
        return cursoService.findCursosInscriptosByUsuarioAndNombre(idUsuario, nombre);
    }

    @Override
    public List<Curso> findCursosNoInscriptosByUsuarioAndNombre(
            @RequestParam("idUsuario") Long idUsuario,
            @RequestParam("nombre") Optional<String> nombre) {
        return cursoService.findCursosNoInscriptosByUsuarioAndNombre(idUsuario, nombre);
    }
}
