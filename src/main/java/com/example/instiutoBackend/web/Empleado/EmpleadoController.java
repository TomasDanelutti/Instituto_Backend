package com.example.instiutoBackend.web.Empleado;

import com.example.instiutoBackend.model.Empleado;
import org.springframework.validation.BindingResult;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EmpleadoController {

    List<Empleado> getEmpleadosPaginado(Integer pageNo, Integer pageSize, Optional<String> nombre);

    Long contarEmpleados(Optional<String> nombre);

    Empleado guardarEmpleado(Empleado empleado, BindingResult result) throws Exception;

    List<Empleado> findEmpleadosByPuesto(String puesto);
}
