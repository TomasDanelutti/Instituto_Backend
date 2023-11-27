package com.example.institutoBackend.service.Rol;

import com.example.institutoBackend.dao.Rol.RolDao;
import com.example.institutoBackend.model.Rol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
@RequiredArgsConstructor
@Transactional
public class RolServiceImpl implements RolService{

    private final RolDao rolDao;

    @Override
    public Rol findRol(Number idRol, BindingResult result) throws Exception {
        return rolDao.findRolByIdRol(idRol);
    }
}
