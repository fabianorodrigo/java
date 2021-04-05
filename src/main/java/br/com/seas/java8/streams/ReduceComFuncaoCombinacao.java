package br.com.seas.java8.streams;

import java.util.Arrays;
import java.util.List;

public class ReduceComFuncaoCombinacao {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // REDUCE É PARA SE TRABALHAR COM OBJETOS IMUTÁVEIS

        // reduce pega todos os elementos de uma lista e transforma em uma única coisa.
        // o que é essa coisa vai depender da implementação da "função acumuladora"
        // passa os dois primeiros itens da lista, depois passa o resultado disso e o
        // terceiro item, depois passa o resultado disso e o quarto item ...
        //
        // Essa assinatura do reduce recebe o primeiro parâmetro o VALOR DE IDENTIDADE
        // e também uma função de combinação. A função de combinação é chamada caso
        // esteja executando em streams em paralelo e só faz sentido se com ela isso
        // levar a um melhor desempenho

        String reduceSoma = list.stream().reduce("", (n1, n2) -> n1.toString().concat(n2.toString()),
                (n1, n2) -> n1.concat(n2));
        System.out.print("Reduce Soma com função de combinação : ");
        System.out.println(reduceSoma);
    }
}
