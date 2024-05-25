package com.mballem.demoparkapi.repository;

import com.mballem.demoparkapi.entity.ClienteVaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteVagaRepository extends JpaRepository<ClienteVaga, Long> {
    Optional<ClienteVaga> findByReciboAndDataSaidaIsNull(String recibo);

    Long countByClienteCpfAndDataSaidaIsNotNull(String cpf);
}
