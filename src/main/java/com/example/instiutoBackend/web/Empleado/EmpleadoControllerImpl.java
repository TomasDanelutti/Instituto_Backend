package com.example.instiutoBackend.web.Empleado;

import com.example.instiutoBackend.model.Empleado;
import com.example.instiutoBackend.service.Empleado.EmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoControllerImpl implements EmpleadoController {

    private final EmpleadoService administratvoService;

    @Override
    @GetMapping("/findBy/{pageNo}/{pageSize}")
    @ResponseStatus(HttpStatus.OK)
    public List<Empleado> findEmpleadosPaginados(@PathVariable("pageNo") Integer pageNo,
                                                      @PathVariable("pageSize") Integer pageSize) {
        return administratvoService.findEmpleadosPaginados(pageNo, pageSize);
    }

    @Override
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long contarEmpleados() {
        return administratvoService.contarEmpleados();
    }

    @Override
    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return administratvoService.guardarEmpleado(empleado);
    }

    @Override
    @GetMapping("/findByNombre/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Empleado> findEmpleadosByNombre(@PathVariable("nombre") String nombre) {
        return administratvoService.findEmpleadosByNombre(nombre);
    }
}
