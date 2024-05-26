package com.mballem.demoparkapi.repository.projection;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ClienteVagaProjection {
    String getPlaca();

    String getMarca();

    String grtModelo();

    String getCor();

    String getClienteCpf();

    String getRecibo();

    LocalDateTime getDataEntrada();

    LocalDateTime getDataSaida();

    String getVagaCodigo();

    BigDecimal getValor();

    BigDecimal getDesconto();
}

