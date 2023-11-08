package com.example.pw3.controllers;

import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pw3.dto.ResumoDTO;
import com.example.pw3.models.Conta;
import com.example.pw3.services.ContaService;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {
    private ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Collection<Conta>> findAll() {
        Collection<Conta> contas = service.findAll();

        return ResponseEntity.ok(contas);
    }

    @RequestMapping(value = "/resumo", method = RequestMethod.GET)
    public ResponseEntity<ResumoDTO> findResumo() {
        ResumoDTO resumo = service.findResumo();

        return ResponseEntity.ok(resumo);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        Conta contaSalva = service.save(conta);

        return ResponseEntity.ok(contaSalva);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<Conta> delete(@RequestBody Conta conta) {
        Conta contaDelete = service.delete(conta);

        return ResponseEntity.ok(contaDelete);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Conta> update(@RequestBody Conta conta) {
        Conta contaUpdate = service.updateById(conta);

        return ResponseEntity.ok(contaUpdate);
    }
}
