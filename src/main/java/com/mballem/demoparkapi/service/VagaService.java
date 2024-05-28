package com.mballem.demoparkapi.service;

import com.mballem.demoparkapi.entity.Vaga;
import com.mballem.demoparkapi.enums.Status;
import com.mballem.demoparkapi.exception.CodigoUniqueViolationException;
import com.mballem.demoparkapi.exception.EntityNotFoundException;
import com.mballem.demoparkapi.exception.VagaDisponivelException;
import com.mballem.demoparkapi.repository.VagaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VagaService {

    private final VagaRepository vagaRepository;

    @Transactional
    public Vaga salvar(Vaga vaga) {
        try {
            return vagaRepository.save(vaga);
        } catch (DataIntegrityViolationException ex) {
            throw new CodigoUniqueViolationException("Vaga", vaga.getCodigo());
        }
    }

    @Transactional(readOnly = true)
    public Vaga buscarPorCodigo(String codigo) {
        return vagaRepository.findByCodigo(codigo).orElseThrow(
                () -> new EntityNotFoundException("Vaga", codigo)
        );
    }

    @Transactional(readOnly = true)
    public Vaga buscarVagaVazia() {
        return vagaRepository.findFirstByStatus(Status.LIVRE).orElseThrow(
                ()->new VagaDisponivelException()
        );
    }
}
