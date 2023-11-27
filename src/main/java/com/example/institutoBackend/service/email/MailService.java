package com.example.institutoBackend.service.email;



import com.example.institutoBackend.model.*;

import java.io.IOException;

public interface MailService {
	void sendMailSolicitudGenerarNuevaClave(Persona persona) throws IOException;

	void sendMailGeneracionClaveEmpleado(Empleado empleado, UsuarioLogin usuarioLogin) throws IOException;

	void sendMailCrearCuentaAlumno(Alumno alumno) throws IOException;

	void sendMailGeneraionTokenDesinscripcion(Desinscripcion desinscripcion) throws IOException;

	void cancelarDesinscripcion(Desinscripcion desinscripcion) throws IOException;
}
