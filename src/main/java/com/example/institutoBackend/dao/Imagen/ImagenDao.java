package com.example.institutoBackend.dao.Imagen;

import com.example.institutoBackend.model.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenDao extends JpaRepository<Archivo, Long> {
}
