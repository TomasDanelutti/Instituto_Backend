package com.example.instiutoBackend.service.email;

import com.example.instiutoBackend.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

	private final String serverUrl;
	private final JavaMailSender emailSender;
    private final String from = "Instituto T&L<tomasdanelutti12@gmail.com>";
	private void sendMail(String to, String subject, String msg) {

		try {
			
			MimeMessage message = emailSender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(message, true);
		    
		    helper.setFrom(from);
		    helper.setTo(to);
		    helper.setSubject(subject);
		    helper.setText(msg, true);
			
			emailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sendMailGeneracionClaveEmpleado(Empleado empleado, UsuarioLogin usuarioLogin) throws IOException {
		var file = ResourceUtils.getFile("classpath:templates/sendMailGeneracionClaveEmpleado.html");
		var message = new String(Files.readAllBytes(file.toPath()));
		message = message.replace("$Nombre", empleado.findNombreApellido()).replace("$puesto", empleado.getPuesto()).replace("$NuevaClave", usuarioLogin.getClave());

		sendMail(empleado.getEmail(), "Instituto T&L S.A - Creación de cuenta", message);
	}

	@Override
	public void sendMailCrearCuentaAlumno(Alumno alumno) throws IOException {
		var file = ResourceUtils.getFile("classpath:templates/sendMaiCrearCuentaAlumno.html");
		var message = new String(Files.readAllBytes(file.toPath()));
		message = message.replace("$Nombre", alumno.findNombreApellido());

		sendMail(alumno.getEmail(), "Instituto T&L S.A - Solicitud de cambio de clave", message);
	}

	@Override
	public void sendMailSolicitudGenerarNuevaClave(Persona persona) throws IOException {
		String urlRecuperarClave = serverUrl + "generarClave/" + persona.getUuid().toString();
		var file = ResourceUtils.getFile("classpath:templates/sendMailSolicitudGenerarNuevaClave.html");
		var message = new String(Files.readAllBytes(file.toPath()));
		message = message.replace("$Nombre", persona.findNombreApellido()).replace("$UrlRecuperarClave", urlRecuperarClave);

		sendMail(persona.getEmail(), "Instituto T&L S.A - Solicitud de cambio de clave", message);
	}

	@Override
	public void sendMailGeneraionTokenDesinscripcion(Desinscripcion desinscripcion) throws IOException {
		var file = ResourceUtils.getFile("classpath:templates/sendMailGeneracionTokenDesinscripcion.html");
		var message = new String(Files.readAllBytes(file.toPath()));
		message = message.replace("$Nombre", desinscripcion.getAlumno().findNombreApellido()).replace("$token", desinscripcion.getToken());

		sendMail(desinscripcion.getAlumno().getEmail(), "Instituto T&L S.A - Token de seguridad para solicitud de desinscripción", message);
	}

	@Override
	public void cancelarDesinscripcion(Desinscripcion desinscripcion) throws IOException {
		var file = ResourceUtils.getFile("classpath:templates/sendMailCalcelarDesinscripcion.html");
		var message = new String(Files.readAllBytes(file.toPath()));
		message = message.replace("$Nombre", desinscripcion.getAlumno().findNombreApellido()).replace("$administrativo", desinscripcion.getEmpleado().findNombreApellido()).replace("$motivo", desinscripcion.getMotivo());

		sendMail(desinscripcion.getAlumno().getEmail(), "Instituto T&L S.A - Actualización de su solicitud de Desinscripción", message);
	}

}
