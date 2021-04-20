package br.com.seas.java8.streams.interfacesFuncionais;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class SupplierEConsumer {
    public static void main(String[] args) {

        // O Java 8 veio com algumas interfaces para se utilizar com os Streams
        // são interfaces funcionais (têm inclusive a anotação @FunctionInterface)

        // O Stream.generate recebe um Supplier. O Supplier só tem um método get
        // que não recebe nenhum parâmetro e retorna algum valor.
        Stream.generate(() -> new Random().nextInt()).forEach(System.out::println);

        // por outro lado, o forEach recebe uma interface funcional 'Consumer'
        // que tem um método accept que recebe um valor e não retorna nada

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach((x) -> System.out.println(x));
    }
}
