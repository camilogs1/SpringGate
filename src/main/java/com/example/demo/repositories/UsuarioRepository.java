package com.example.demo.repositories;

import com.example.demo.models.UsuarioModel;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    UsuarioModel findByemail(String email);

    ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}