package com.example.usarios.demo.repository;

import com.example.usarios.demo.model.UsuarioVO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<UsuarioVO, String> {

    List<UsuarioVO> findAll();

    Optional<UsuarioVO> findById(String id);

    List<UsuarioVO> findByNombreContaining(String nombre);
    
    void deleteById(String id);

}