package com.example.demo.repositories;

// import java.lang.reflect.Array;
// import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ProductosModel;

@Repository
public interface ProductosRepository<Producto> extends JpaRepository<ProductosModel, Long> {

    public abstract List<ProductosModel> findAll();

}