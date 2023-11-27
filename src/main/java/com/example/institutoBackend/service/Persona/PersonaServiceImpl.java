package com.example.institutoBackend.service.Persona;

import com.example.institutoBackend.dao.Persona.PersonaDao;
import com.example.institutoBackend.dao.Rol.RolDao;
import com.example.institutoBackend.model.Persona;
import com.example.institutoBackend.service.email.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonaServiceImpl implements PersonaService {

    private final PersonaDao usuarioDao;

    private final MailService mailService;

    private final RolDao rolDao;

    @Override
    public Persona login(Long dni, String clave) throws Exception {
        Persona persona = usuarioDao.findPersonaByDni(dni);

        if (persona == null ) {
            throw new Exception("clave incorrecto.");
        }
        return persona;
    }

    @Override
    public Persona findUsuarioByDni(Long dni) {
        Persona persona = usuarioDao.findUsuarioByDni(dni);
        return usuarioDao.findUsuarioByDni(dni);
    }

    @Override
    public void findAlumnoByDni(Long dni) {
        usuarioDao.findUsuarioByDni(dni);
    }


}
