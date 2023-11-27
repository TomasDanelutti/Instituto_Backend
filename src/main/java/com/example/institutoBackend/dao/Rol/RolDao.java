package com.example.institutoBackend.dao.Rol;

import com.example.institutoBackend.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol, Long> {

    Rol findRolByIdRol(Number idRol);

}
