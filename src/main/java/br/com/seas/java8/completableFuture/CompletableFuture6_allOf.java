package br.com.seas.java8.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CompletableFuture6_allOf {

    /***********************************************************************
     * CompletableFuture is at the same time a building block and a framework, with
     * about 50 different methods for composing, combining, and executing
     * asynchronous computation steps and handling errors.
     * 
     * https://www.baeldung.com/java-completablefuture
     * 
     ************************************************************************/

    public static void main(String[] args) {

        // Quando é necessário executar múltiplas Futures em paralelo, geralmente, é
        // necessário esperar pelo resultado de todas para processar esses resultados
        // juntos. O CompletableFuture.allOf permite aguardar todas serem completadas
        CompletableFuture<String> futureOla = CompletableFuture.supplyAsync(() -> "Olá ");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "como vai ");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "você? ");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Eu preciso ");
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> "saber ");
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> "da sua vida");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futureOla, future1, future2, future3, future4,
                future5);

        try {
            combinedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // como o allOf gera uma Future<Void>, precisamos obter manualmente os
        // resultados das Futures originais
        String combined = Stream.of(futureOla, future1, future2, future3, future4, future5).map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println(combined);
    }

    public static int enrolando() {
        int soma = IntStream.range(1, 1_000_000).reduce(0, (a, b) -> a + b);
        System.out.print("olha a soma da enrolação: ");
        System.out.println(soma);
        return soma;
    }
}