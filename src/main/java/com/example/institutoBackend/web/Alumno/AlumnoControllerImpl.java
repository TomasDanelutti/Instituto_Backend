package com.example.institutoBackend.web.Alumno;


import com.example.institutoBackend.model.Alumno;
import com.example.institutoBackend.service.Alumno.AlumnoService;
import com.example.institutoBackend.system.ErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoControllerImpl implements AlumnoController {

    private final AlumnoService alumnoService;

    @Override
    @GetMapping("/getAlumnosPaginado")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_INSTITUCION') or hasAuthority('ROLE_ADMINISTRATIVO')")
    public List<Alumno> getAlumnosPaginado(@RequestParam("pageNo") Integer pageNo,
                                           @RequestParam("pageSize") Integer pageSize,
                                           @RequestParam("nombre") Optional<String> nombre) {
        return alumnoService.getAlumnosPaginado(pageNo, pageSize, nombre);
    }

    @Override
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('ROLE_INSTITUCION') or hasAuthority('ROLE_ADMINISTRATIVO')")
    public Long contarAlumnos(@RequestParam("nombre") Optional<String> nombre)
    {
        return alumnoService.contarAlumnos(nombre);
    }

    @Override
    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_INSTITUCION') or hasAuthority('ROLE_ADMINISTRATIVO')")
    public Alumno guardarAlumno(@RequestBody @Valid Alumno alumno, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception(ErrorHandler.handle(result.getFieldErrors()));
        }
        return alumnoService.guardarAlumno(alumno);
    }
}
