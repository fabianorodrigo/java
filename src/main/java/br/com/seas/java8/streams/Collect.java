package br.com.seas.java8.streams;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // COLLECT É PARA SE TRABALHAR COM OBJETOS MUTÁVEIS (REDUCE IMUTÁVEIS)

        // o collect recebe uma função 'supplier', que retorna a instância do objeto que
        // será utilizado para acumular; uma função 'acumuladora' que recebe dois
        // parâmetros, o objeto que armazena os resultados (List, Set, etc) e um
        // argumento do stream; e uma função de 'combinação' para o caso do stream
        // esteja sendo executado em paralelo

        List<Integer> collect = list.stream().collect(() -> new ArrayList<Integer>(), (l, e) -> l.add(e),
                (l1, l2) -> l1.addAll(l2));
        System.out.print("Collect de List.add : ");
        System.out.println(collect.toString());

        List<Integer> collect2 = list.stream().collect(Collectors.toList());
        System.out.print("Collect de lista já tem pronto no Java 8: ");
        System.out.println(collect2.toString());

        Set<Integer> collect3 = list.stream().collect(Collectors.toSet());
        System.out.print("O Collect de Set também já tem pronto no Java 8: ");
        System.out.println(collect3.toString());

        Deque<Integer> collect4 = list.stream().collect(Collectors.toCollection(() -> new ArrayDeque<Integer>()));
        System.out.print(
                "O Collect também já tem um outro genérico 'toCollection' que basta passar a função 'supplier' que retorne um Collection: ");
        System.out.println(collect4.toString());

        String collectString = list.stream().map(e -> e.toString()).collect(Collectors.joining());
        System.out.print("o joining concatena strings usando StringBuilder por baixo: ");
        System.out.println(collectString.toString());

        Double media = list.stream().collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.print("o averagingInt retorna a media de inteiros: ");
        System.out.println(media.toString());

        Integer soma = list.stream().collect(Collectors.summingInt(n -> n.intValue()));
        System.out.print("o summingInt retorna a soma de inteiros: ");
        System.out.println(soma.toString());

        Long qtd = list.stream().collect(Collectors.counting());
        System.out.print("o counting retorna a quantidade de valores na lista: ");
        System.out.println(qtd.toString());

        Optional<Integer> min = list.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.print("o minBy recebe um Comparator e retorna o menor valor: ");
        System.out.println(min.get().toString());

        Optional<Integer> max = list.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.print("o maxBy recebe um Comparator e retorna o menor valor: ");
        System.out.println(max.get().toString());

        IntSummaryStatistics stats = list.stream().collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.print("o summarizingInt retorna várias estatísticas de números inteiros: ");
        System.out.println(stats.toString());

        // STREAMS.collect groupingBy
        System.out.println("O groupingBy agrupa o stream pelo resultado da função lambda (resto da divisão por 3): ");
        Map<Integer, List<Integer>> mapaDeLista = list.stream().collect(Collectors.groupingBy(e -> e % 3));
        System.out.println(mapaDeLista);

        // STREAMS.collect partitioningBy (agrupa apenas entre TRUE e FALSE)
        System.out.println("O partitioningBy agrupa o stream pelo resultado da função lambda QUE DEVE SER BOOLEANO: ");
        Map<Boolean, List<Integer>> mapaParticao = list.stream().collect(Collectors.partitioningBy(e -> e % 3 == 0));
        System.out.println(mapaParticao);

        // STREAMS.collect toMap recebe uma função lambda para pegar a chave e outra pra
        // pegar o valor
        System.out.println("O toMap define uma função que pega chave do Map e outra que pega o valor: ");
        Map<Integer, Integer> ToMap = list.stream().collect(Collectors.toMap(n -> n, n -> n ^ 5));
        System.out.println(ToMap);

    }
}
