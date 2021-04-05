package br.com.seas.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

public class ReduceComValorIdentidade {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // REDUCE É PARA SE TRABALHAR COM OBJETOS IMUTÁVEIS

        // reduce pega todos os elementos de uma lista e transforma em uma única coisa.
        // o que é essa coisa vai depender da implementação da "função acumuladora"
        // passa os dois primeiros itens da lista, depois passa o resultado disso e o
        // terceiro item,
        // depois passa o resultado disso e o quarto item ...
        //
        // Essa assinatura do reduce recebe o primeiro parâmetro o VALOR DE IDENTIDADE.
        // VALOR DE IDENTIDADE: é o valor que n1 tem que ter para que o resultado seja
        // igual ao n2
        // Nessa assinatura, não é retornado um Optional, mas o próprio tipo
        // Caso o stream() esteja vazio, é o valor de identidade que será retornado

        // No caso da soma, o valor de identidade é 0: se você passar 0 em n1, o
        // resultado será exatamente n2, seja ele qual for
        // No caso da multiplicação, o valor de identidade é 1: se você passar 1 em n1,
        // o resultado será exatamente n2, seja ele qual for
        // No caso de concatenação de strings, o valor de identidade é uma string vazia
        // ...

        Integer reduceSoma = list.stream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.print("Reduce Soma : ");
        System.out.println(reduceSoma);

        Integer reduceSomaVazio = (new ArrayList<Integer>()).stream().reduce(0, (n1, n2) -> n1 + n2);
        System.out.print("Reduce Soma com lista vazia: ");
        System.out.println(reduceSomaVazio);

        Integer reduceMultiplicacao = list.stream().reduce(1, (n1, n2) -> n1 * n2);
        System.out.print("Reduce MUltiplicação : ");
        System.out.println(reduceMultiplicacao);

        String[] palavras = "Oi tudo bem".split(" ");

        String reduceConcatenacao = Arrays.asList(palavras).stream().reduce("", (n1, n2) -> n1 + " " + n2);
        System.out.print("Reduce Concatenacao : ");
        System.out.println(reduceConcatenacao);

        double reduceMin = DoubleStream.of(1.5, 2.9, 0.4).reduce(Double.POSITIVE_INFINITY,
                (d1, d2) -> Math.min(d1, d2));
        System.out.print("Reduce Double Valor Mínimo : ");
        System.out.println(reduceMin);

    }
}
