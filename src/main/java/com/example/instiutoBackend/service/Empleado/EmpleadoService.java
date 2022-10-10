package com.example.instiutoBackend.service.Empleado;

import com.example.instiutoBackend.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    List<Empleado> findEmpleadosPaginados(Integer pageNo, Integer pageSize);

    Long contarEmpleados();

    Empleado guardarEmpleado(Empleado empleado);

    List<Empleado> findEmpleadosByNombre(String nombre);
}
