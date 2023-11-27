package com.example.institutoBackend.dao.UsuarioLogin;

import com.example.institutoBackend.model.UsuarioLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioLoginDao extends JpaRepository<UsuarioLogin, Long> {

    UsuarioLogin findUsuarioLoginByDni(Long dni);
}
