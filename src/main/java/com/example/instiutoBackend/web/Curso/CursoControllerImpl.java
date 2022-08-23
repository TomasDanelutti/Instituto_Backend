package com.example.instiutoBackend.web.Curso;

import com.example.instiutoBackend.model.Curso;
import com.example.instiutoBackend.service.Curso.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoControllerImpl implements CursoController{

    private final CursoService cursoService;

    @Override
    @GetMapping()
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    @Override
    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Curso guardarCurso(@RequestBody Curso curso, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception("Datos incompletos");
        }
        return cursoService.guardarCurso(curso);
    }

    @Override
    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.CREATED)
    public Curso eliminarCurso(@RequestBody Curso curso, BindingResult result) throws Exception {
        return cursoService.eliminarCurso(curso);
    }

    @Override
    @GetMapping("/findByNombre/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> findCursoByNombre(@PathVariable("nombre") String nombre) {
        return cursoService.findCursoByNombre(nombre);
    }

    @Override
    @GetMapping("/findNoInscriptos/{idUsuario}")
    public List<Curso> findCursoNoInscriptosByUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return cursoService.findCursoNoInscriptosByUsuario(idUsuario);
    }

    @Override
    @GetMapping("/findInscriptos/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> findCursoInscriptosByUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return cursoService.findCursoInscriptosByUsuario(idUsuario);
    }
}
