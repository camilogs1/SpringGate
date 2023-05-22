package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ProductosModel;
import com.example.demo.repositories.ProductosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductosService {
    @Autowired
    private ProductosRepository<ProductosModel> productosRepository; ;
    
    public ArrayList<ProductosModel> obtenerproductos(){
        return (ArrayList<ProductosModel>) productosRepository.findAll();
    }

    public Optional<ProductosModel> obtenerPorId(Long id){
        return productosRepository.findById(id);
    }
}
