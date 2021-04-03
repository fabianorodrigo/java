package br.com.seas.java8.period_duration;

import java.time.Duration;
import java.time.LocalTime;

public class APITimeDuration {
    // Durações de tempo em horas, minutos, segundos
    public static void main(String[] args) {
        Duration n = Duration.ofDays(3);
        System.out.println("Estabeler duração: " + n.toString());

        LocalTime agora = LocalTime.now();
        LocalTime daquiUmTempo = agora.plusMinutes(10).plusSeconds(55);
        Duration espacoTempo = Duration.between(agora, daquiUmTempo);
        System.out.println("Calcula espaço de tempo entre dois horários: " + espacoTempo.toString());

        Duration doisDias = Duration.ofDays(2);
        System.out.println("Também dá pra somar unidades de tempo ao Duration: " + espacoTempo.plus(doisDias));
    }
}
