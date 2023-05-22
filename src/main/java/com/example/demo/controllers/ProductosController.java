package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.ProductosModel;
import com.example.demo.repositories.ProductosRepository;

@Controller
public class ProductosController {

    @Autowired
    private ProductosRepository<ProductosModel> productosRepository; 
    
    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        // Obtener todos los productos de la base de datos
        Iterable<ProductosModel> productos = productosRepository.findAll();
        
        // Pasar los productos al modelo para que estén disponibles en la vista
        model.addAttribute("productos", productos);
        
        // Devolver el nombre de la vista donde se mostrarán los productos (por ejemplo, "productos.html")
        return "productos";
    }
}
