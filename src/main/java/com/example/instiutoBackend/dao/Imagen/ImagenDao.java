package com.example.instiutoBackend.dao.Imagen;

import com.example.instiutoBackend.model.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenDao extends JpaRepository<Archivo, Long> {
}
