package br.com.seas.java8.period_duration;

import java.time.LocalDate;
import java.time.Period;

public class APITimePeriod {
    // Períodos de tempo
    public static void main(String[] args) {
        Period n = Period.of(1, 5, 3);
        System.out.println("Estabeler duração de período em anos, mês dia: " + n.toString());

        LocalDate agora = LocalDate.now();
        LocalDate daquiUmTempo = agora.plusDays(10).plusMonths(2);
        Period espacoTempo = Period.between(agora, daquiUmTempo);
        System.out.println("Calcula espaço de tempo entre duas datas" + espacoTempo.toString());

        Period cincoAnos = Period.ofYears(4);
        System.out.println("Também dá pra somar unidades de tempo ao Period: " + espacoTempo.plus(cincoAnos));
    }
}
