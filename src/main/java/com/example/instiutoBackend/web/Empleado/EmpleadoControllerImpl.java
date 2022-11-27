package com.example.instiutoBackend.web.Empleado;

import com.example.instiutoBackend.model.Empleado;
import com.example.instiutoBackend.service.Empleado.EmpleadoService;
import com.example.instiutoBackend.system.ErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoControllerImpl implements EmpleadoController {

    private final EmpleadoService empleadoService;

    @Override
    @GetMapping("/findBy/{pageNo}/{pageSize}")
    @ResponseStatus(HttpStatus.OK)
    public List<Empleado> findEmpleadosPaginados(@PathVariable("pageNo") Integer pageNo,
                                                      @PathVariable("pageSize") Integer pageSize) {
        return empleadoService.findEmpleadosPaginados(pageNo, pageSize);
    }

    @Override
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long contarEmpleados() {
        return empleadoService.contarEmpleados();
    }

    @Override
    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado guardarEmpleado(@Validated @RequestBody Empleado empleado, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception(ErrorHandler.handle(result.getFieldErrors()));
        }
        return empleadoService.guardarEmpleado(empleado);
    }

    @Override
    @GetMapping("/findByNombre/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Empleado> findEmpleadosByNombre(@PathVariable("nombre") String nombre) {
        return empleadoService.findEmpleadosByNombre(nombre);
    }

    @Override
    @GetMapping("/findByPuesto/{puesto}")
    @ResponseStatus(HttpStatus.OK)
    public List<Empleado> findEmpleadosByPuesto(@PathVariable("puesto") String puesto) {
        return empleadoService.findEmpleadosByPuesto(puesto);
    }
}
