package com.example.instiutoBackend.web.Empleado;

import com.example.instiutoBackend.model.Empleado;

import java.io.IOException;
import java.util.List;

public interface EmpleadoController {

    List<Empleado> findEmpleadosPaginados(Integer pageNo, Integer pageSize);

    Long contarEmpleados();

    Empleado guardarEmpleado(Empleado empleado) throws IOException;

    List<Empleado> findEmpleadosByNombre(String nombre);

    List<Empleado> findEmpleadosByPuesto(String puesto);
}
