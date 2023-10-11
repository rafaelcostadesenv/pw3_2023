package com.example.pw3.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.pw3.models.Conta;
import com.example.pw3.repositories.ContaRepository;

@Service
public class ContaService {

    private ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public Collection<Conta> findAll() {
        return repository.findAll();
    }

    public Conta save(Conta conta) {
        return repository.save(conta);
    }
}
