package com.example.instiutoBackend.service.email;


import com.example.instiutoBackend.model.DTOS.DesinscripcionDTO;
import com.example.instiutoBackend.model.Desinscripcion;
import com.example.instiutoBackend.model.Empleado;
import com.example.instiutoBackend.model.Persona;
import com.example.instiutoBackend.model.UsuarioLogin;

import java.io.IOException;

public interface MailService {
	void sendMailSolicitudGenerarNuevaClave(Persona persona) throws IOException;

	void sendMailGeneracionClaveEmpleado(Empleado empleado, UsuarioLogin usuarioLogin) throws IOException;

	void sendMailGeneraionTokenDesinscripcion(Desinscripcion desinscripcion) throws IOException;

	void cancelarDesinscripcion(Desinscripcion desinscripcion) throws IOException;
}
