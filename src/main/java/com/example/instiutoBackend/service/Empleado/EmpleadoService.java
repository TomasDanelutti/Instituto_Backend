package com.example.instiutoBackend.service.Empleado;

import com.example.instiutoBackend.model.Empleado;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    List<Empleado> getEmpleadosPaginado(Integer pageNo, Integer pageSize, Optional<String> nombre);

    Long contarEmpleados(Optional<String> nombre);

    Empleado guardarEmpleado(Empleado empleado) throws IOException;

    List<Empleado> findEmpleadosByPuesto(String puesto);
}
