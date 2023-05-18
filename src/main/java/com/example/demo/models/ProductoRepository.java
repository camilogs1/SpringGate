package com.example.demo.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository<Producto> extends JpaRepository<Producto, Long> {
    // Puedes agregar métodos personalizados para consultas específicas si lo deseas
}

