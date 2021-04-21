package br.com.seas.java8.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class CompletableFuture7_handle {

    /***********************************************************************
     * CompletableFuture is at the same time a building block and a framework, with
     * about 50 different methods for composing, combining, and executing
     * asynchronous computation steps and handling errors.
     * 
     * https://www.baeldung.com/java-completablefuture
     * 
     ************************************************************************/

    public static void main(String[] args) {

        CompletableFuture<String> futureInicial = CompletableFuture.supplyAsync(() -> "Olá ");

        // O método 'handle' de uma instância de CompletableFuture recebe uma
        // BiFunction (@FunctionInterface) cujas entradas são o resultado da cadeia de
        // futures e uma exceção. Já o retorno, é o que resultado final da cadeia que se
        // deseja retornar
        CompletableFuture<String> futureFinal = futureInicial.thenCompose(
                fn -> CompletableFuture.supplyAsync(() -> fn.concat(" Mundão sem porteira mas com thenCompose")));
        CompletableFuture<String> rFinal = futureFinal.handle((resultado, excecao) -> {
            if (resultado != null) {
                return resultado + " (depois do handle)";
            } else {
                return "Mete um valor default que deu merda";
            }
        });
        try {
            System.out.println(rFinal.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static int enrolando() {
        int soma = IntStream.range(1, 1_000_000).reduce(0, (a, b) -> a + b);
        System.out.print("olha a soma da enrolação: ");
        System.out.println(soma);
        return soma;
    }
}