package com.example.instiutoBackend.service.email;

import com.example.instiutoBackend.model.Persona;
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
    private final String from = "Instituto Zarasa<tomasdanelutti12@gmail.com>";
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
	public void sendMailGeneracionNuevaClave(Persona persona) throws IOException {
		var file = ResourceUtils.getFile("classpath:templates/sendMailGeneracionNuevaClave.html");
		var message = new String(Files.readAllBytes(file.toPath()));
		message = message.replace("$Nombre", persona.getNombre()).replace("$NuevaClave", "persona.getClave()");

		sendMail(persona.getEmail(), "Instituto Zarasa S.A - Nueva clave", message);
	}

	@Override
	public void sendMailSolicitudGenerarNuevaClave(Persona persona) throws IOException {
		String urlRecuperarClave = serverUrl + "generarClave/" + persona.getUuid().toString();
		var file = ResourceUtils.getFile("classpath:templates/sendMailSolicitudGenerarNuevaClave.html");
		var message = new String(Files.readAllBytes(file.toPath()));
		message = message.replace("$Nombre", persona.getNombre()).replace("$UrlRecuperarClave", urlRecuperarClave);

		sendMail(persona.getEmail(), "Instituto Zarasa S.A - Pedido de cambio de clave", message);
	}

}
