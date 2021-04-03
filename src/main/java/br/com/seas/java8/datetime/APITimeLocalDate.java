package br.com.seas.java8.datetime;

import java.time.LocalDate;

public class APITimeLocalDate {

    // Somente data (sem hora, sem timezone)
    public static void main(String[] args) {
        LocalDate n = LocalDate.now();
        System.out.println("Somente data agora: " + n.toString());

        LocalDate ld = LocalDate.of(1979, 7, 16);
        System.out.println(
                "Ao contrário da antiga classe de data, os meses não iniciam em 0 (janeiro) mas sim em 1 (janeiro): "
                        + ld.toString());

        LocalDate ld2 = ld.plusDays(1);
        System.out
                .println("É possível adicionar dias ao um LocalDate com o método imutável plusDays: " + ld2.toString());
    }
}
