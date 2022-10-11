package com.example.instiutoBackend.web.Empleado;

import com.example.instiutoBackend.model.Empleado;

import java.util.List;

public interface EmpleadoController {

    List<Empleado> findEmpleadosPaginados(Integer pageNo, Integer pageSize);

    Long contarEmpleados();

    Empleado guardarEmpleado(Empleado empleado);

    List<Empleado> findEmpleadosByNombre(String nombre);

    List<Empleado> findEmpleadosByPuesto(String puesto);
}
