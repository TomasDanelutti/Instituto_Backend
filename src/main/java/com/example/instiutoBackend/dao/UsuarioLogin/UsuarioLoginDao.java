package com.example.instiutoBackend.dao.UsuarioLogin;

import com.example.instiutoBackend.model.UsuarioLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioLoginDao extends JpaRepository<UsuarioLogin, Long> {
}
