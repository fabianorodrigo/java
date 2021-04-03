package br.com.seas.java8.datetime;

import java.time.LocalDateTime;

public class APITimeLocalDateTime {

    // Data e hora (sem timezone)
    public static void main(String[] args) {
        LocalDateTime n = LocalDateTime.now();

        System.out.println("Data e Hora local agora: " + n.toString());
    }
}
