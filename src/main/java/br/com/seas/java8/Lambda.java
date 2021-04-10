package br.com.seas.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Lambda {

    // https://rinaldo.dev/video-java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo-parte-1/
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // LAMBDA (função no formato (params)->{....}
        System.out.println("LAMBDA: Imprime todos os elementos da lista!");
        list.forEach(n -> System.out.println(n));

        // Se for passar apenas o único parâmetro para o forEach, basta passar o objeto
        // '::' e o método
        IntStream.range(0, 5).filter(n -> n % 2 == 0).forEach(System.out::println);

        // Se tiver mais de uma instrução, tem que colocar chaves ({ e })
        // '::' e o método
        IntStream.range(0, 5).filter(n -> {
            System.out.println(n);
            return n % 2 == 0;
        }).forEach(System.out::println);
    }
}