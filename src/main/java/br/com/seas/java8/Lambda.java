package br.com.seas.java8;

import java.util.Arrays;
import java.util.List;

public class Lambda{

    //https://rinaldo.dev/video-java-8-streams-pare-de-usar-for-e-simplifique-seu-codigo-parte-1/
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        //LAMBDA (função no formato (params)->{....}
        System.out.println("LAMBDA: Imprime todos os elementos da lista!");
        list.forEach(n -> System.out.println(n));        
    }
}