package com.example.instiutoBackend.dao.Rol;

import com.example.instiutoBackend.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol, Long> {

    Rol findRolByIdRol(Number idRol);

}
