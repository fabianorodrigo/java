package br.com.seas.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams {

    // https://rinaldo.dev/video-java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo-parte-1/
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // STREAMS.skip
        System.out.println("Imprime elementos da lista: pula os 2 primeiros");
        list.stream().skip(2).forEach(n -> System.out.println(n));

        // STREAMS.limit
        System.out.println("Imprime elementos da lista: limita aos 2 primeiros");
        list.stream().limit(2).forEach(n -> System.out.println(n));

        // STREAMS.distinct
        System.out.println("Imprime elementos da lista distintos");
        list.stream().distinct().forEach(n -> System.out.println(n));

        // STREAMS.filter
        System.out.println("Imprime elementos da lista filtrando pares");
        list.stream().filter(e -> e % 2 == 0).forEach(n -> System.out.println(n));

        // STREAMS.map (transformação é cópia, não afeta lista original)
        System.out.println("Imprime elementos da lista transformando (map)");
        list.stream().map(e -> e * 2).forEach(n -> System.out.println(n));

        // STREAMS.count
        System.out.println("Imprime contagem de elementos pares da lista");
        long count = list.stream().filter(e -> e % 2 == 0).count();
        System.out.println(count);

        // STREAMS.min
        System.out.println("Imprime menor dos elementos pares da lista");
        Optional<Integer> min = list.stream().filter(e -> e % 2 == 0).min(Comparator.naturalOrder());
        System.out.println(min.get());

        // STREAMS.collect toList
        System.out.println("Obtém uma nova lista obtida após um filtro STREAMS");
        List<Integer> novaLista = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(novaLista);

        // STREAMS.collect groupingBy
        System.out.println("Agrupa os o resultado da transformação (map) entre números pares e ímpares");
        Map<Boolean, List<Integer>> mapaDeLista = list.stream().map(e -> e * 3)
                .collect(Collectors.groupingBy(e -> e % 2 == 0));
        System.out.println(mapaDeLista);

        // STREAMS.collect joining
        System.out.println("Concatena strings separando por ';'");
        String concatenacao = list.stream().map(e -> String.valueOf(e)).collect(Collectors.joining(";"));
        System.out.println(concatenacao);
    }
}