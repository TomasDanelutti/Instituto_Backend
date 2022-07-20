package com.example.instiutoBackend.dao.Usuario;

import com.example.instiutoBackend.model.Rol;
import com.example.instiutoBackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    @Query("FROM Usuario u WHERE u.dni = :dni" +
            " AND u.clave = :clave")
    Usuario loginUser(Long dni, String clave);

    @Query("from Usuario u where u.rol.idRol = :idRol")
    List<Usuario> findUsuariosByRol(Number idRol);

    List<Usuario> findUsuariosByRol(Rol rol);


}
