package br.com.seas.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MethodReference {

    // https://rinaldo.dev/video-java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo-parte-1/
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // o Method Reference é exatamente o sinal '::' que significa passar
        // um método como parâmetro lambda
        list.stream().forEach(System.out::println);
        // sem Method Reference seria assim, mais verboso
        list.stream().forEach(n -> System.out.println(n));

        // Method Reference com método estático
        list.stream().map(MethodReference::multipliquePorDois);

        // Method Reference com construtores
        list.stream().map(BigDecimal::new);

    }

    private static Integer multipliquePorDois(Integer i) {
        return i * 2;
    }
}