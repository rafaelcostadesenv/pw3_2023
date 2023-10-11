package com.example.pw3.repositories;

import org.springframework.stereotype.Repository;

import com.example.pw3.models.Conta;

@Repository
public interface ContaRepository extends AbstractRepository<Conta, Long> {

}
