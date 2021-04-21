package br.com.seas.java8.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class CompletableFuture5_thenCombineVsthenAcceptBoth {

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

        // O método 'thenCombine' de uma instância de CompletableFuture recebe uma
        // Future e uma interface funcional (@FunctionInterface) BiFunction. Os
        // argumentos dessa BiFunction são exatamente o retorno da Future original e da
        // Future passada por parâmetro. Essa BiFunction deve retornar algo
        CompletableFuture<String> futureFinal = futureInicial.thenCombine(
                CompletableFuture.supplyAsync(() -> " Mundão sem porteira mas com thenCompose"),
                (rOriginal, rParametro) -> rOriginal + rParametro);

        /**
         * If we want to execute two independent Futures and do something with their
         * results, we can use the thenCombine
         */

        // O método 'thenAcceptBoth' é exatamente como o 'thenCombine', com a diferença
        // de que, ao invés de receber um BiFunction, recebe um BiConsumer. Assim, ele
        // não retornará nenhum valor para da cadeia de Futures
        CompletableFuture<Void> futureFinal2 = futureInicial.thenAcceptBoth(
                CompletableFuture.supplyAsync(() -> " Mundão sem porteira mas com thenCompose"),
                (rOriginal, rParametro) -> System.out.print(rOriginal + rParametro));
        System.out.println(futureFinal2);

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