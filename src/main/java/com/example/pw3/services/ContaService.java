package com.example.pw3.services;

import java.util.Collection;

import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.example.pw3.dto.ResumoDTO;
import com.example.pw3.models.Conta;
import com.example.pw3.repositories.ContaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaService {

    private ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public Collection<Conta> findAll() {
        return repository.findAll();
    }

    public ResumoDTO findResumo() {
        Collection<Conta> despesas = repository.findByTipo(Conta.TIPO_DESPESA);
        Collection<Conta> receitas = repository.findByTipo(Conta.TIPO_RECEITA);
        double totalDespesas = despesas.stream().mapToDouble(d-> d.getValor()).sum();
        double totalReceitas = receitas.stream().mapToDouble(d-> d.getValor()).sum();
        double saldo = totalReceitas - totalDespesas;
        ResumoDTO resumo = new ResumoDTO();
        resumo.setSaldo(saldo);
        resumo.setTotalDespesa(totalDespesas);
        resumo.setTotalReceita(totalReceitas);
        return resumo;
    }

    public Conta save(Conta conta) {
        return repository.save(conta);
    }

    public Conta delete(Conta conta) {
        repository.delete(conta);
        return conta;
    }

    public Conta updateById(Conta conta) {
        try {
            Conta contaAtualizada = repository.findById(conta.getId())
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada com ID: " + conta.getId()));

            // Atualiza os campos da conta

            contaAtualizada.setCategoria(conta.getCategoria());
            contaAtualizada.setTipo(conta.getTipo());
            contaAtualizada.setData(conta.getData());
            contaAtualizada.setDescricao(conta.getDescricao());
            contaAtualizada.setValor(conta.getValor());
            contaAtualizada.setDestinoOrigem(conta.getDestinoOrigem());
            contaAtualizada.setStatus(conta.getStatus());

            return repository.save(contaAtualizada);
        } catch (EntityNotFoundException e) {
            return new Conta();
        }
    }
}
