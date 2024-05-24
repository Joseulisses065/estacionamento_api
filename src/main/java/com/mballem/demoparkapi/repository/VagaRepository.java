package com.mballem.demoparkapi.repository;

import com.mballem.demoparkapi.entity.Vaga;
import com.mballem.demoparkapi.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    Optional<Vaga> findByCodigo(String codigo);

    Optional<Vaga> findFirstByStatus(Status status);
}
