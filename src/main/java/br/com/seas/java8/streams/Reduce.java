package br.com.seas.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // REDUCE É PARA SE TRABALHAR COM OBJETOS IMUTÁVEIS

        // reduce pega todos os elementos de uma lista e transforma em uma única coisa.
        // o que é essa coisa vai depender da implementação da "função acumuladora"
        // passa os dois primeiros itens da lista, depois passa o resultado disso e o
        // terceiro item,
        // depois passa o resultado disso e o quarto item ...
        //
        // A função acumuladora tem que ser uma função associativa para que o mesmo
        // resultado seja obtido tanto em streams únicos quanto em paralelos
        Optional<Integer> reduceSoma = list.stream().reduce((n1, n2) -> n1 + n2);
        System.out.print("Reduce Soma : ");
        reduceSoma.ifPresent(action -> System.out.println(action.toString()));

        Optional<Integer> reduceMultiplicacao = list.stream().reduce((n1, n2) -> n1 * n2);
        System.out.print("Reduce MUltiplicação : ");
        reduceMultiplicacao.ifPresent(action -> System.out.println(action.toString()));

        String[] palavras = "Oi tudo bem".split(" ");

        Optional<String> reduceConcatenacao = Arrays.asList(palavras).stream().reduce((n1, n2) -> n1 + " " + n2);
        System.out.print("Reduce Concatenacao : ");
        reduceConcatenacao.ifPresent(action -> System.out.println(action.toString()));
    }
}
