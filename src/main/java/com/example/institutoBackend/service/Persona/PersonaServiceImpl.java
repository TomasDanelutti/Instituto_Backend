package com.example.institutoBackend.service.Persona;

import com.example.institutoBackend.dao.Persona.PersonaDao;
import com.example.institutoBackend.model.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonaServiceImpl implements PersonaService {

    private final PersonaDao personaDao;

    @Override
    @Transactional
    public Persona getPersonaSession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var dni = Integer.valueOf(authentication.getName());
        return personaDao.findPersonaByDni(Long.valueOf(dni));
    }
}
