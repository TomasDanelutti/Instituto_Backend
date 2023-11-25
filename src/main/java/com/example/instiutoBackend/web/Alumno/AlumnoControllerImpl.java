package com.example.instiutoBackend.web.Alumno;

import com.example.instiutoBackend.model.Alumno;
import com.example.instiutoBackend.service.Alumno.AlumnoService;
import com.example.instiutoBackend.system.ErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoControllerImpl implements AlumnoController {

    private final AlumnoService alumnoService;

    @Override
    @GetMapping("/getAlumnosPaginado")
    @ResponseStatus(HttpStatus.OK)
    public List<Alumno> getAlumnosPaginado(@RequestParam("pageNo") Integer pageNo,
                                            @RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("nombre") Optional<String> nombre) {
        return alumnoService.getAlumnosPaginado(pageNo, pageSize, nombre);
    }

    @Override
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long contarAlumnos(@RequestParam("nombre") Optional<String> nombre)
    {
        return alumnoService.contarAlumnos(nombre);
    }

    @Override
    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Alumno guardarAlumno(@RequestBody @Valid Alumno alumno, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception(ErrorHandler.handle(result.getFieldErrors()));
        }
        return alumnoService.guardarAlumno(alumno);
    }
}
