package com.example.pw3.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.pw3.models.Categoria;
import com.example.pw3.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Collection<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }
}
