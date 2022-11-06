package com.example.instiutoBackend.service.email;


import com.example.instiutoBackend.model.Persona;

import java.io.IOException;

public interface MailService {
	void sendMailSolicitudGenerarNuevaClave(Persona persona) throws IOException;

	void sendMailGeneracionNuevaClave(Persona persona) throws IOException;
}
