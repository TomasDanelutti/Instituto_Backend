package com.example.instiutoBackend.web.Alumno;

import com.example.instiutoBackend.model.Alumno;
import com.example.instiutoBackend.service.Alumno.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
@RequiredArgsConstructor
public class AlumnoControllerImpl implements AlumnoController {

    private final AlumnoService alumnoService;

    @Override
    @GetMapping("/findBy/{pageNo}/{pageSize}")
    @ResponseStatus(HttpStatus.OK)
    public List<Alumno> findAlumnosPaginados(@PathVariable("pageNo") Integer pageNo,
                                             @PathVariable("pageSize") Integer pageSize) {
        return alumnoService.findAlumnosPaginados(pageNo, pageSize);
    }

    @Override
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long contarAlumnos() {
        return alumnoService.contarALumnos();
    }

    @Override
    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Alumno guardarAlumno(@RequestBody Alumno alumno, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception("Datos incompletos");
        }
        return alumnoService.guardarAlumno(alumno);
    }

    @Override
    @GetMapping("/findByNombre/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Alumno> findAlumnosByNombre(@PathVariable("nombre") String nombre) {
        return alumnoService.findALumnosByNombre(nombre);
    }
}
