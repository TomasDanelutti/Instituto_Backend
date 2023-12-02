package com.example.institutoBackend.web.Empleado;

import com.example.institutoBackend.model.Empleado;
import com.example.institutoBackend.service.Empleado.EmpleadoService;
import com.example.institutoBackend.system.ErrorHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class EmpleadoControllerImpl implements EmpleadoController {

    private final EmpleadoService empleadoService;

    @Override
    @GetMapping("/getEmpleadosPaginado")
    @ResponseStatus(HttpStatus.OK)
    public List<Empleado> getEmpleadosPaginado(@RequestParam("pageNo") Integer pageNo,
                                               @RequestParam("pageSize") Integer pageSize,
                                               @RequestParam("nombre") Optional<String> nombre) {
        return empleadoService.getEmpleadosPaginado(pageNo, pageSize, nombre);
    }

    @Override
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long contarEmpleados(@RequestParam("nombre") Optional<String> nombre) {
        return empleadoService.contarEmpleados(nombre);
    }

    @Override
    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado guardarEmpleado(@Valid @RequestBody Empleado empleado, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception(ErrorHandler.handle(result.getFieldErrors()));
        }
        return empleadoService.guardarEmpleado(empleado);
    }

    @Override
    @GetMapping("/findByPuesto/{idPuestoEmpleado}")
    public List<Empleado> findEmpleadosByPuestoEmpleado(@PathVariable Long idPuestoEmpleado) {
        return empleadoService.findEmpleadosByPuestoEmpleado(idPuestoEmpleado);
    }

}
