package com.example.instiutoBackend.service.email;


import com.example.instiutoBackend.model.*;
import com.example.instiutoBackend.model.DTOS.DesinscripcionDTO;

import java.io.IOException;

public interface MailService {
	void sendMailSolicitudGenerarNuevaClave(Persona persona) throws IOException;

	void sendMailGeneracionClaveEmpleado(Empleado empleado, UsuarioLogin usuarioLogin) throws IOException;

	void sendMailCrearCuentaAlumno(Alumno alumno) throws IOException;

	void sendMailGeneraionTokenDesinscripcion(Desinscripcion desinscripcion) throws IOException;

	void cancelarDesinscripcion(Desinscripcion desinscripcion) throws IOException;
}
