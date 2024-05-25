package com.mballem.demoparkapi.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EstacionamentoUtils {

    private static final double PRIMEIROS_15_MINUTES = 5.00;
    private static final double PRIMEIROS_60_MINUTES = 9.25;
    private static final double ADICIONAL_15_MINUTES = 1.75;
    private static final double DESCONTO_PERCENTUAL = 0.30;


    public static String GerarRecibo(){
        LocalDateTime date = LocalDateTime.now();
        String recibo = date.toString().substring(0,19);
        return recibo.replace("-","").replace(":","").replace("T","-");

    }

    public static BigDecimal calcularCusto(LocalDateTime entrada, LocalDateTime saida) {
        long minutes = entrada.until(saida, ChronoUnit.MINUTES);
        double total = 0.0;

        if (minutes <= 15) {

            total=PRIMEIROS_15_MINUTES;
        } else if (minutes <= 60) {
            total=PRIMEIROS_60_MINUTES;

            // complete com a lógica para calcular o custo até os primeiros 60 minutos de uso

        } else {
            total=PRIMEIROS_60_MINUTES;
           double minutosM = minutes-PRIMEIROS_60_MINUTES;
           double  quinze = Math.ceil((minutosM/15.00));
           total += (quinze*ADICIONAL_15_MINUTES);
        }

        return new BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN);

    }

    public static void main(String[]args){
        System.out.println(calcularDesconto(new BigDecimal(5.00),13..19));
    }

    public static BigDecimal calcularDesconto(BigDecimal custo, long numeroDeVezes) {

        // Complete o código com a sua lógica
        BigDecimal desconto = null;

        if ((numeroDeVezes>0)&&(numeroDeVezes%10==0)){
            desconto = new BigDecimal(custo.doubleValue()*DESCONTO_PERCENTUAL);
        }else {
            return new BigDecimal("0.00");
        }

        return desconto.setScale(2, RoundingMode.HALF_EVEN);
    }
}
