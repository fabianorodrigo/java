package br.com.seas.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LambdaCollections {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        // removeIf: recebe um Predicate que avalia e remove o item se retornar
        // verdadeiro
        System.out.println("REMOVE OS PARES");
        list.removeIf(n -> n % 2 == 0);
        list.forEach(System.out::println);

        // replaceAll: recebe uma função que será aplicada a todos os elementos
        // MODIFICANDO-OS, ou seja, é mutável
        System.out.println("DOBRA O QUE SOBROU");
        list.replaceAll(n -> n * 2);
        list.forEach(System.out::println);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(5, "Katisoca");
        map.put(7, "Fabi");
        map.put(8, "Mary Pô");

        // forEach do mapa recebe um Biconsumer
        System.out.println("PERCORRA MAP");
        map.forEach((k, v) -> System.out.println(k + ": " + v));

        // compute: busca a tupla com a chave passada no primeiro parâmetro e
        // trabalha com ela na função BiConsumer passada como segundo parâmetro,
        // que deve retornar um valor. Esse valor sobrescreverá o valor da tupla
        System.out.println("COMPUTE");
        map.compute(7, (k, v) -> "Nascimento nasceu em " + k);
        map.forEach((k, v) -> System.out.println(k + ": " + v));

        // merge: busca a tupla com a chave passada no primeiro parâmetro
        System.out.println("MERGE COM CHAVE QUE JÁ EXISTE NO MAPA");
        map.merge(8, "oops", (v1, v2) -> v1 + v2);
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("MERGE COM CHAVE QUE NÃO EXISTE NO MAPA");
        map.merge(4, "oops", (v1, v2) -> v1 + v2);
        map.forEach((k, v) -> System.out.println(k + ": " + v));

        // replaceAll: map também tem :)
        System.out.println("REPLACEALL NO MAP");
        map.replaceAll((k, v) -> v + " Nascimento");
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}