package com.example.institutoBackend.service.auth;

import com.example.institutoBackend.dao.Persona.PersonaDao;
import com.example.institutoBackend.model.Estado;
import com.example.institutoBackend.model.Persona;
import com.example.institutoBackend.model.Respuesta;
import com.example.institutoBackend.model.SolicitudGenerarClave;
import com.example.institutoBackend.service.email.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService{
    private final PersonaDao usuarioDao;
    private final MailService mailService;

    @Override
    public Respuesta olvideMiClave(Long dni) throws IOException {
        Persona persona = usuarioDao.findPersonaByDni(dni);
        Assert.notNull(persona, "El DNI ingresado no corresponde a un usuario registrado.");
        mailService.sendMailSolicitudGenerarNuevaClave(persona);
        String email = persona.getEmail();
        return new Respuesta(Estado.OK, "Hemos enviado un enlace para generar una nueva clave a " + email);
    }

    @Override
    public Persona getUsuario(UUID uuid) {
       // Persona personaBD = usuarioDao.findUsuarioByUuid(uuid);
       // Assert.notNull(personaBD, "Ha ocurrido un error y no hemos podido obtener el usuario");
       // Persona persona = new Persona();
       // persona.setNombre(personaBD.getNombre());
       // persona.setApellido(personaBD.getApellido());
       // persona.setDni(personaBD.getDni());
       // return persona;
        return null;
    }

    @Override
    public Respuesta cambiarClave(SolicitudGenerarClave solicitudGenerarClave) {
        Persona persona = usuarioDao.findPersonaByDni(solicitudGenerarClave.getDni());
        Assert.notNull(persona, "Ha ocurrido un error y no hemos podido obtener el usuario");
        usuarioDao.save(persona);
        return new Respuesta(Estado.OK, "Su contraseña ha sido cambiarda correctamente");
    }

}
