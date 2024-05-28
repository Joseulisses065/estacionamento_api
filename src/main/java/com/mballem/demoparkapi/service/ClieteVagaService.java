package com.mballem.demoparkapi.service;

import com.mballem.demoparkapi.entity.ClienteVaga;
import com.mballem.demoparkapi.exception.EntityNotFoundException;
import com.mballem.demoparkapi.exception.ReciboNotFoundException;
import com.mballem.demoparkapi.jwt.JwtUserDetails;
import com.mballem.demoparkapi.repository.ClienteVagaRepository;
import com.mballem.demoparkapi.repository.projection.ClienteVagaProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ClieteVagaService {
    private final ClienteVagaRepository clienteVagaRepository;

    @Transactional
    public ClienteVaga save(ClienteVaga clientVacancy) {
        return clienteVagaRepository.save(clientVacancy);
    }

    @Transactional(readOnly = true)
    public ClienteVaga buscarRecibo(String recibo) {
        return clienteVagaRepository.findByReciboAndDataSaidaIsNull(recibo).orElseThrow(
                () -> new ReciboNotFoundException("Recibo",recibo)
        );
    }

    @Transactional(readOnly = true)
    public Long getTotalDeVezesEstacionamentoCompleto(String cpf) {
        return clienteVagaRepository.countByClienteCpfAndDataSaidaIsNotNull(cpf);
    }

    @Transactional(readOnly = true)
    public Page<ClienteVagaProjection> buscarTodosPorClienteCpf(String cpf, Pageable pageable) {
        return clienteVagaRepository.findAllByClienteCpf(cpf,pageable);
    }

    @Transactional(readOnly = true)
    public Page<ClienteVagaProjection> buscarTodosPorUsuarioId(Long userId, Pageable pageable) {
        return clienteVagaRepository.findAllByClienteUsuarioId(userId,pageable);
    }
}
