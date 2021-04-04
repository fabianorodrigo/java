package br.com.seas.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class APITimeDateTimeFormatter {

    // Formatação de data/hora
    public static void main(String[] args) {
        LocalDateTime n = LocalDateTime.now();

        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("Formatação ISO: " + isoFormatter.format(n));

        DateTimeFormatter localizedSHORT = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println("Formatação local SHORT (de acordo como Locale): " + localizedSHORT.format(n));

        DateTimeFormatter localizedLONG = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println("Formatação local LONG (de acordo com o Locale): " + localizedLONG.format(n));

        DateTimeFormatter localizedFULL = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println("Formatação local FULL (de acordo com o Locale): " + localizedFULL.format(n));

        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd,MM,YYYY HH:mm:ss");
        System.out.println("Formatação customizada: " + customFormatter.format(n));

        System.out
                .println("Também dá pra formatar passando o Formatter para o objeto Data: " + n.format(localizedLONG));

        TemporalAccessor parse = localizedSHORT.parse("16/07/1979");
        System.out.println("Também dá pra fazer parse" + LocalDate.from(parse).toString());

    }
}
