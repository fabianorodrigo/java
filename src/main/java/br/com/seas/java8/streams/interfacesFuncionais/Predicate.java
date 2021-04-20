package br.com.seas.java8.streams.interfacesFuncionais;

import java.util.Arrays;
import java.util.List;

public class Predicate {
    public static void main(String[] args) {

        // O Java 8 veio com algumas interfaces para se utilizar com os Streams
        // são interfaces funcionais (têm inclusive a anotação @FunctionInterface)

        // O Stream.filter recebe um Predicate. O Predicate recebe um valor
        // e retorna um booleano
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.stream().filter(x -> x % 2 == 0).forEach((x) -> System.out.println(x));

        // Existe também o BiPredicate que recebe DOIS valores e retorna um booleano

    }
}
