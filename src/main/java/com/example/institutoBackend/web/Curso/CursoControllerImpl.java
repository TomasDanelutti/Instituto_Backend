package com.example.institutoBackend.web.Curso;

import com.example.institutoBackend.model.Curso;
import com.example.institutoBackend.model.Respuesta;
import com.example.institutoBackend.service.Curso.CursoService;
import com.example.institutoBackend.service.Persona.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoControllerImpl implements CursoController{

    private final CursoService cursoService;

    @Override
    @PreAuthorize("hasAuthority('ROLE_INSTITUCION') or hasAuthority('ROLE_EMPLEADO')")
    @GetMapping("/getCursosPaginado")
    public List<Curso> GetCursosPaginado(@RequestParam("pageNo") Integer pageNo,
                                         @RequestParam("pageSize") Integer pageSize,
                                         @RequestParam("nombre") Optional<String> nombre) {
        return cursoService.GetCursosPaginado(pageNo, pageSize, nombre);
    }

    @Override
    @GetMapping("/count")
    @PreAuthorize("hasAuthority('ROLE_INSTITUCION') or hasAuthority('ROLE_EMPLEADO')")
    public Long countCursos(@RequestParam("nombre") Optional<String> nombre) {
        return cursoService.countCursos(nombre);
    }

    @Override
    @PostMapping("guardar")
    @PreAuthorize("hasAuthority('ROLE_INSTITUCION') or hasAuthority('ROLE_EMPLEADO')")
    @ResponseStatus(HttpStatus.CREATED)
    public Curso guardarCurso(@RequestBody @Valid Curso curso, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception("Datos incompletos");
        }
        return cursoService.guardarCurso(curso);
    }

    @Override
    @DeleteMapping("/{idCurso}")
    @PreAuthorize("hasAuthority('ROLE_INSTITUCION') or hasAuthority('ROLE_EMPLEADO')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Respuesta eliminarCurso(@PathVariable Long idCurso) throws Exception {
       return cursoService.eliminarCurso(idCurso);
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_INSTITUCION') or hasAuthority('ROLE_EMPLEADO') or hasAuthority('ROLE_ALUMNO')")
    @GetMapping("/findCursosByPersonaAndNombre")
    public List<Curso> findCursosByUsuarioAndNombre(
            @RequestParam("nombre") Optional<String> nombre,
            @RequestParam("inscripto") boolean inscripto,
            @RequestParam("numPage") Integer numPage,
            @RequestParam("pageSize") Integer pageSize) {
        return cursoService.findCursosByUsuarioAndNombre(nombre, inscripto, numPage, pageSize);
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_INSTITUCION') or hasAuthority('ROLE_EMPLEADO') or hasAuthority('ROLE_ALUMNO')")
    @GetMapping("/countCursosByPersonaAndNombre")
    public Long countCursosByUsuarioAndNombre(
            @RequestParam("nombre") Optional<String> nombre,
            @RequestParam("inscripto") boolean inscripto) {
        return cursoService.countCursosByUsuarioAndNombre(nombre, inscripto);
    }
}
