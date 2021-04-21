package br.com.seas.java8.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class CompletableFuture4_thenCompose {

    /***********************************************************************
     * CompletableFuture is at the same time a building block and a framework, with
     * about 50 different methods for composing, combining, and executing
     * asynchronous computation steps and handling errors.
     * 
     * https://www.baeldung.com/java-completablefuture
     * 
     ************************************************************************/

    private static ExecutorService executor = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {

        /**
         * The best part of the CompletableFuture API is the ability to combine
         * CompletableFuture instances in a chain of computation steps.
         * 
         * The result of this chaining is itself a CompletableFuture that allows further
         * chaining and combining. This approach is ubiquitous in functional languages
         * and is often referred to as a MONADIC design pattern.
         */

        CompletableFuture<String> futureInicial = CompletableFuture.supplyAsync(() -> "Olá ");

        // O método 'thenCompose' de uma instância de CompletableFuture recebe uma
        // Function (@FunctionInterface) cujo RETORNO é uma instância de
        // CompletableFuture e a ENTRADA é o resultado da Future original
        CompletableFuture<String> futureFinal = futureInicial.thenCompose(
                fn -> CompletableFuture.supplyAsync(() -> fn.concat(" Mundão sem porteira mas com thenCompose")));

        /**
         * thenApply: We can use this method to work with a result of the previous call.
         * However, a key point to remember is that the return type will be combined of
         * all calls. So this method is useful when we want to transform the result of a
         * CompletableFuture call
         * 
         * thenCompose: is similar to thenApply() in that both return a new Completion
         * Stage. However, thenCompose() uses the previous stage as the argument. It
         * will FLATTEN and return a Future with the result directly, rather than a
         * nested future as we observed in thenApply():
         * 
         * So if the idea is to chain CompletableFuture methods then it’s better to use
         * thenCompose().
         */

        enrolando();
        String resultado;
        try {
            // espera N segundos, se não voltar, exceção
            final int N = 3;
            resultado = futureFinal.get(N, TimeUnit.SECONDS);
            System.out.println(resultado);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }

    public static int enrolando() {
        int soma = IntStream.range(1, 1_000_000).reduce(0, (a, b) -> a + b);
        System.out.print("olha a soma da enrolação: ");
        System.out.println(soma);
        return soma;
    }
}