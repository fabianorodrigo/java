package br.com.seas.java8.streams.interfacesFuncionais;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Function {
    public static void main(String[] args) {

        // O Java 8 veio com algumas interfaces para se utilizar com os Streams
        // são interfaces funcionais (têm inclusive a anotação @FunctionInterface)

        // O Stream.map recebe uma Function. O Function recebe um valor
        // e retorna outro valor
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.stream().map(x -> x.toString()).forEach((x) -> System.out.println(x));

        // Existe também o BiFunction que recebe DOIS valores e retorna um outro valor

        // Existe também o UnaryOperator que é uma extensão de Function mas
        // entrada e saída são do mesmo tipo

        // Por sua vez, o BinaryOperator que recebe DOIS que é uma extensão do
        // BiFunction mas as duas entradas e a saída são do mesmo tipo. Esse tipo é
        // usado pelo Reduce
        Optional<Integer> reduceSoma = list.stream().reduce((n1, n2) -> n1 + n2);
        System.out.println(reduceSoma.get());
    }
}
